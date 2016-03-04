package com.ddlottery.service;

import com.ddlottery.dao.DDaccountMapper;
import com.ddlottery.dao.DDbusinessMapper;
import com.ddlottery.dao.DDdrawMapper;
import com.ddlottery.model.DDaccount;
import com.ddlottery.model.DDbusiness;
import com.ddlottery.model.DDdraw;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/2/19.
 */
@Service
public class DDaccountService {

    public static final Integer pageSize = 20;

    @Autowired
    DDaccountMapper DDaccountMapper;

    @Autowired
    DDdrawMapper DDdrawMapper;

    @Autowired
    DDbusinessMapper DDbusinessMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public Integer addDraw(DDdraw draw){
        DDbusiness business = DDbusinessMapper.selectByPrimaryKey(draw.getBid());
        if(draw.getMoney()>business.getOutmoney()){
            return 1;
        }
        if(business.getBankcode().equals("")){
            return 2;
        }
        draw.setRealname(business.getRealname());
        draw.setBank(business.getBank());
        draw.setBankname(business.getBankname());
        draw.setBancode(business.getBankcode());
        draw.setCreattime(new Date());
        draw.setState((byte) 0);
        DDdrawMapper.insertSelective(draw);
        business.setMoney(business.getMoney() - draw.getMoney());
        business.setOutmoney(business.getOutmoney()-draw.getMoney());
        DDbusinessMapper.updateByPrimaryKeySelective(business);
        DDaccount account = new DDaccount();
        account.setBid(draw.getBid());
        account.setBname(business.getBname());
        account.setMoney(0 - draw.getMoney());
        account.setNowmoney(business.getMoney());
        account.setType((byte)2);
        account.setState((byte)0);
        account.setCreattime(new Date());
        DDaccountMapper.insertSelective(account);

        return 0;
    }

    public Map busineeAccountList(Integer bid,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDaccountMapper.selectByBid(bid, pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public Map DrawList(Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDdrawMapper.selectAll(pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public Map DrawListByBid(Integer bid,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDdrawMapper.selectByBid(bid,pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public Integer EditDrawState(Integer id, byte state){
        SqlSession session = sqlSessionFactory.openSession(false);
        DDdraw draw =  DDdrawMapper.selectByPrimaryKey(id);
        if(draw.getState()>0){
            return 1;
        }
        draw.setId(id);
        draw.setState(state);
        draw.setSuretime(new Date());
        DDdrawMapper.updateByPrimaryKeySelective(draw);
        if (state == 2){
            DDbusiness business = DDbusinessMapper.selectByPrimaryKey(draw.getBid());
            business.setMoney(business.getMoney() + draw.getMoney());
            business.setOutmoney(business.getOutmoney()+ draw.getMoney());
            DDbusinessMapper.updateByPrimaryKeySelective(business);
            DDaccount account = new DDaccount();
            account.setBid(draw.getBid());
            account.setBname(business.getBname());
            account.setMoney(draw.getMoney());
            account.setNowmoney(business.getMoney());
            account.setType((byte)5);
            account.setState((byte)0);
            account.setCreattime(new Date());
            DDaccountMapper.insertSelective(account);
        }
        session.commit();
        session.close();
        return 0;
    }

    public Integer AccountRecharge(Integer bid, Float money,String msg){
        SqlSession session = sqlSessionFactory.openSession(false);
        DDbusiness business = DDbusinessMapper.selectByPrimaryKey(bid);
        business.setMoney(business.getMoney()+money);
        DDbusinessMapper.updateByPrimaryKeySelective(business);
        DDaccount account = new DDaccount();
        account.setBid(business.getBid());
        account.setBname(business.getBname());
        account.setMoney(money);
        account.setNowmoney(business.getMoney());
        account.setType((byte) 1);
        account.setState((byte) 0);
        account.setCreattime(new Date());
        account.setMsg(msg);
        DDaccountMapper.insertSelective(account);
        session.commit();
        session.close();
        return 0;
    }

}
