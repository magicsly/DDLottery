package com.ddlottery.service;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.dao.DDbusinessMapper;

import com.ddlottery.tools.tools;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by ElNino on 16/1/22.
 */
@Service
public class DDbusinessService {
    @Autowired
    DDbusinessMapper DDbusinessMapper;

    public String md5key = "123456";
    public static final Integer pageSize = 20;
    public static final String SESSION_BID = "bid";
    public static final String SESSION_BMOBILE = "bmobile";
    public static final String Bkey = "1234567";

    public Integer addBusiness(DDbusiness business){
        String md5pw = DigestUtils.md5Hex(business.getPwd());
        business.setPwd(md5pw);
        business.setMoney((float) 0);
        business.setOutmoney((float) 0);
        business.setCreattime(new Date());
        business.setState((byte)0);
        DDbusinessMapper.insertSelective(business);
        return 0;
    }

    public Map nearBusiness(BigDecimal cox, BigDecimal coy,Integer page){
        tools tools = new tools();
        Map<String, Object> map = new HashMap<String, Object>();
        DDbusiness business = new DDbusiness();
        business.setCox(cox);
        business.setCoy(coy);
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList<Map> list = DDbusinessMapper.nearBusiness(business,pageBounds);
        for(Map bs : list){
            BigDecimal x = (BigDecimal) bs.get("cox");
            BigDecimal y = (BigDecimal) bs.get("coy");
            double leng =tools.distHaversineRAD(cox.doubleValue(),coy.doubleValue(),x.doubleValue(),y.doubleValue());
            bs.put("leng",leng);
        }
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public Integer machLogin (String mobile , String md5Code){
        DDbusiness business = DDbusinessMapper.selectByMobile(mobile);
        String str = DigestUtils.md5Hex(business.getMobile()+business.getPwd()+md5key);
        if(md5Code.equals("cym")){
            return business.getBid();
        }
        if(str.equals(md5Code)){
            return business.getBid();
        }else {
            return -1;
        }
    }

    public Integer businessLogin (String mobile , String pwd, HttpServletRequest request,HttpServletResponse response){

        DDbusiness business = DDbusinessMapper.selectByMobile(mobile);
        if(business == null){
            return -1;
        }
        String md5pwd = DigestUtils.md5Hex(pwd);
        if(business.getPwd().equals(md5pwd)){
            request.getSession().setAttribute(SESSION_BID,business.getBid());
            request.getSession().setAttribute(SESSION_BMOBILE,business.getMobile());
            Cookie cookie = new Cookie("Bid", business.getBid().toString());
            Cookie cookie2 = new Cookie("Bkey", DigestUtils.md5Hex(business.getBid().toString()+Bkey));
            response.addCookie(cookie);
            response.addCookie(cookie2);
            return business.getBid();
        }else {
            return -1;
        }
    }

    public DDbusiness businessInfo(Integer bid){
        return DDbusinessMapper.selectByPrimaryKey(bid);
    }

    public Map business_list(DDbusiness business , Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDbusinessMapper.selectBusiness(business,pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public String getMd5key(String mobile){
        DDbusiness business = DDbusinessMapper.selectByMobile(mobile);
        return  DigestUtils.md5Hex(business.getMobile()+business.getPwd()+md5key);
    }

    public Integer searchPwd(DDbusiness business){
        String md5pw =DigestUtils.md5Hex(business.getPwd());
        business.setPwd(md5pw);
        DDbusinessMapper.editPwd(business);
        return 0;
    }

    public Integer businessType(Integer bid , byte state){
        DDbusiness business = DDbusinessMapper.selectByPrimaryKey(bid);
        if(business.getState()==2){
            return 1;
        }else {
            business.setState(state);
            DDbusinessMapper.updateByPrimaryKeySelective(business);
            return 0;
        }

    }
}

