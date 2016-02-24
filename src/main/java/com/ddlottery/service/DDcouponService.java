package com.ddlottery.service;

import com.ddlottery.dao.*;
import com.ddlottery.model.*;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlottery.tools.md5_16;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/2/3.
 */
@Service
public class DDcouponService {

    @Autowired
    DDcouponMapper DDcouponMapper;

    @Autowired
    DDcouponInfoMapper DDcouponInfoMapper;

    @Autowired
    DDuserMapper DDuserMapper;

    @Autowired
    DDbusinessMapper DDbusinessMapper;

    @Autowired
    DDaccountMapper DDaccountMapper;

    @Resource
    private SqlSessionFactory sqlSessionFactory;

    public static final String couponekey = "cpdyj";
    public static final Integer pageSize = 20;

    public Integer addCoupon(DDcoupon coupon){
        coupon.setRestnum(coupon.getNum());
        coupon.setUsenum(0);
        coupon.setCreattime(new Date());
        coupon.setStates((byte)0);
        if(coupon.getFullmuch() != null){
            if(coupon.getFullmuch()>0){
                coupon.setTypes((byte) 2);
            }else {
                coupon.setTypes((byte) 3);
            }
        }
        if(DDcouponMapper.selectFullmuchCount(coupon)>0){
            return 1;
        }
        DDcouponMapper.insertSelective(coupon);
        return 0;
    }

    public Integer editCoupon(DDcoupon coupon){
        DDcouponMapper.updateByPrimaryKeySelective(coupon);
        return 0;
    }

    public ArrayList couponBybid(Integer bid){
        return DDcouponMapper.selectByBid(bid);
    }

    public Map couponList(Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDcouponMapper.selectAll(pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public ArrayList couponByuid(Integer uid,Integer type){
        if(type==0) {
            return DDcouponInfoMapper.selectByUidNow(uid);
        }else{
            return DDcouponInfoMapper.selectByUidAfter(uid);
        }
    }

    public Map couponByCid(Integer cid,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDcouponInfoMapper.selectByCid(cid, pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public Integer receiveCoupon(Integer cid,Integer uid) throws Exception {
        DDcoupon coupon= DDcouponMapper.selectByPrimaryKey(cid);
        Date now = new Date();
        if(coupon.getEndtime().getTime()<now.getTime()) {
            return 1;//已过期
        }
        Integer restnum = coupon.getRestnum()-1;
        if(restnum<0){
            return 2;//已领完
        }
        Map pushmap = new HashMap();
        pushmap.put("cid",cid);
        pushmap.put("uid",uid);
        Integer count = DDcouponInfoMapper.selectCountByCid(pushmap);
        if(count>= coupon.getLimitnum() && coupon.getLimitnum() > -1){
            return 3;//超过领取次数
        }
        coupon.setRestnum(restnum);
        DDcouponMapper.updateByPrimaryKeySelective(coupon);
        DDuser user = DDuserMapper.selectByPrimaryKey(uid);
        DDcouponInfo info = new DDcouponInfo();
        info.setIsuse((byte)0);
        info.setEndtime(coupon.getEndtime());
        info.setStarttime(coupon.getStarttime());
        info.setCid(coupon.getCid());
        info.setUid(uid);
        info.setUname(user.getMobile());
        info.setMoney(coupon.getMoney());
        info.setGettime(new Date());
        DDcouponInfoMapper.insertSelective(info);
        Integer ciid = info.getId();
        String code = md5_16.md5(ciid.toString()+couponekey+user.getMobile()).substring(0,8);
        code = ciid.toString()+"-"+code;
        info.setCodenum(code);
        info.setId(ciid);
        DDcouponInfoMapper.updateByPrimaryKeySelective(info);
        return 0;

    }

    public Integer useCoupon(String code,Integer bid) throws Exception {
        DDcouponInfo info =  DDcouponInfoMapper.selectByCodenum(code);
        if(info == null){
            return 1;//号码错误
        }
        String ciid = code.split("-")[0];
        DDuser user = DDuserMapper.selectByPrimaryKey(info.getUid());
        String codenum = md5_16.md5(ciid.toString()+couponekey+user.getMobile()).substring(0, 8);
        if(!codenum.equals(code.split("-")[1])){
            return 1;//号码错误
        }
        if(info.getIsuse()==1){
            return 2;//已经使用
        }
        Date now = new Date();
        if(info.getEndtime().getTime()<now.getTime()){
            return 3;//已过期
        }
        DDcoupon coupon = DDcouponMapper.selectByPrimaryKey(info.getCid());
        if(coupon.getBid() !="all"){
            if(!coupon.getBid().equals(bid.toString())){
                return 4;//不能再此家店铺使用
            }
        }
        SqlSession session = sqlSessionFactory.openSession(false);
        DDbusiness business = DDbusinessMapper.selectByPrimaryKey(bid);
        info.setBid(bid);
        info.setBmobile(business.getMobile());
        info.setBname(business.getLocname());
        info.setUsetime(new Date());
        info.setIsuse((byte)1);
        DDcouponInfoMapper.updateByPrimaryKeySelective(info);
        coupon.setUsenum(coupon.getUsenum() + 1);
        DDcouponMapper.updateByPrimaryKeySelective(coupon);
        if(coupon.getTypes() == 3) {
            business.setMoney(business.getMoney() + info.getMoney());
            business.setOutmoney(business.getOutmoney() + info.getMoney());
            DDbusinessMapper.updateByPrimaryKey(business);
            DDaccount account = new DDaccount();
            account.setBid(bid);
            account.setBname(business.getBname());
            account.setMoney(info.getMoney());
            account.setNowmoney(business.getMoney());
            account.setType((byte) 4);
            account.setState((byte) 0);
            account.setCreattime(new Date());
            DDaccountMapper.insertSelective(account);
        }
        session.commit();
        session.close();
        return 0;
    }

    public Map userCouponInfo(Integer id){
        Map<String, Object> map = new HashMap<String, Object>();
        map = DDcouponInfoMapper.selectInfo(id);
        return map;
    }

    public Map couponbycode(String codenum){
        Map<String, Object> map = new HashMap<String, Object>();
        map = DDcouponInfoMapper.couponByCode(codenum);
        return map;
    }

    public Map businessCouponList(Integer bid,Integer type,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        Map<String, Object> pushmap = new HashMap<String, Object>();
        pushmap.put("bid",bid.toString());
        pushmap.put("type",type);
        ArrayList list = DDcouponMapper.businessAll(pushmap, pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public Map couponUseList(Integer bid, String codenum ,Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        DDcouponInfo info = new DDcouponInfo();
        info.setBid(bid);
        if(!codenum.equals("")) {
            info.setCodenum(codenum);
        }
        ArrayList list =DDcouponInfoMapper.useCouponByBid(info,pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public Integer couponState(Integer cid , byte states){
        DDcoupon coupon = new DDcoupon();
        coupon.setCid(cid);
        coupon.setStates(states);
        DDcouponMapper.updateByPrimaryKeySelective(coupon);
        return 0;
    }
}
