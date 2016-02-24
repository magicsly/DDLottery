package com.ddlottery.service;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.model.DDorder;
import com.ddlottery.dao.DDorderMapper;
import com.ddlottery.tools.tools;
import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.whatever.lottery.jczq.Bet;
import com.whatever.omr.OmrText;
import com.whatever.slip.SlipJCZQ;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.*;

/**
 * Created by ElNino on 16/1/22.
 */
@Service
public class DDorderService {

    @Autowired
    DDorderMapper DDorderMapper;

    @Autowired
    DDbusinessService DDbusinessService;


    public Integer addorder(DDorder order){
        order.setCreattime(new Date());
        DDorderMapper.insertSelective(order);
        return 0;
    }

    public Map orderList(DDorder order,Integer page){
        Map<String,Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,20);
        ArrayList<DDorder> list = DDorderMapper.selectByOther(order, pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",20);
        map.put("page",page);
        return map;
    }

    public Integer userPrintOrder(Integer oid, Integer bid){
        DDorder order = new DDorder();
        order.setOid(oid);
        order.setBid(bid);
        order.setState((byte)2);
        return 0;
    }

    public Map orderInfo(Integer oid) throws IOException {
        Map<String,Object> map = new HashMap<String, Object>();
        DDorder order = DDorderMapper.selectByPrimaryKey(oid);
        String matchs = order.getContent();
        tools tools = new tools();
        List matchList = tools.getMatch(matchs);
        map.put("code",0);
        map.put("info",order);
        map.put("match",matchList);
        return map;
    }

    public Map machineGetOrder(Integer bid , String md5Code) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        String md5 = DigestUtils.md5Hex(bid.toString() + DDbusinessService.md5key);
        if(md5.equals(md5Code) || md5Code.equals("cym")){
            DDorderMapper.machUpdateList(bid);
            ArrayList<DDorder> list = DDorderMapper.machOrderList(bid);
            for (DDorder info : list) {
                String chuan = info.getStr().split("\\|")[info.getStr().split("\\|").length-1];
                String str=getPrintLotCode(info.getStr(),info.getClosetime().toString(),chuan);
                info.setStr(str);
            }
            map.put("code",0);
            map.put("list",list);
            return map;
        }else {
            map.put("code",-1);
            return map;
        }
    }

    public Integer machinePrintOrder(Integer oid, String md5Code){
        String str = DigestUtils.md5Hex(oid.toString() + DDbusinessService.md5key);
        if(str.equals(md5Code)){
            DDorder order = new DDorder();
            order.setOid(oid);
            order.setIsprint((byte)1);
            order.setState((byte)4);
            order.setPrinttime(new Date());
            DDorderMapper.updateByPrimaryKeySelective(order);
            return 0;
        }else {
            return 1;
        }
    }

    public String getPrintLotCode(
            String betStr,
            String closetime,
            String chuan) {
        try {
            Bet bet = new Bet(betStr);
            String str = SlipJCZQ.parse(bet);

            OmrText t = new OmrText();

            t.appendH1Centerln("彩票投注单");
            //t.appendCenterln("用户名:足球爱好者");
            t.appendCenterln("竞彩足球混合过关  "+chuan);
            t.appendCenterln(UUID.randomUUID().toString());
            t.appendLineln();
            t.appendHex(str);
            t.appendLineln();
            t.appendCenterln("投注单过期时间:"+closetime);
            t.appendCenterln("购彩有风险 投注需谨慎");
            t.appendH1Centerln("请务必核对票面内容！");
            t.appendFeed();
            t.appendCut();
            return t.toString();
        }catch (Exception e){
            return "";
        }
    }
}
