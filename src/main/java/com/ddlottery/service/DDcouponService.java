package com.ddlottery.service;

import com.ddlottery.dao.DDbusinessMapper;
import com.ddlottery.dao.DDcouponInfoMapper;
import com.ddlottery.dao.DDcouponMapper;
import com.ddlottery.dao.DDuserMapper;
import com.ddlottery.model.DDbusiness;
import com.ddlottery.model.DDcoupon;
import com.ddlottery.model.DDcouponInfo;
import com.ddlottery.model.DDuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddlottery.tools.md5_16;

import java.util.ArrayList;
import java.util.Date;

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

    public static final String couponekey = "cpdyj";
    public static final Integer pageSize = 20;

    public Integer addCoupon(DDcoupon coupon){
        coupon.setCreattime(new Date());
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

    public ArrayList couponByuid(Integer uid){
        return DDcouponInfoMapper.selectByUid(uid);
    }

    public Integer receiveCoupon(Integer cid,Integer uid) throws Exception {
        DDcoupon coupon= DDcouponMapper.selectByPrimaryKey(cid);
        Date now = new Date();
        if(coupon.getEndtime().getTime()<now.getTime()) {
            return -1;
        }
        Integer restnum = coupon.getRestnum()-1;
        if(restnum<0){
            return -2;
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
        info.setGettime(new Date());
        Integer ciid = DDcouponInfoMapper.insertSelective(info);
        String code = md5_16.md5(ciid.toString()+couponekey+user.getMobile()).substring(0,8);
        code = ciid.toString()+"-"+code;
        info.setCodenum(code);
        return DDcouponInfoMapper.updateByPrimaryKeySelective(info);

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
        if(info.getEndtime().getTime()>now.getTime()){
            return 3;//已过期
        }
        DDcoupon coupon = DDcouponMapper.selectByPrimaryKey(info.getCid());
        if(coupon.getBid() !="all" && !coupon.getBid().equals(bid)){
            return 4;//不能再此家店铺使用
        }
        DDbusiness business = DDbusinessMapper.selectByPrimaryKey(bid);
        info.setBid(bid);
        info.setBmobile(business.getMobile());
        info.setBname(business.getLocname());
        info.setUsetime(new Date());
        info.setIsuse((byte)1);
        DDcouponInfoMapper.updateByPrimaryKeySelective(info);
        business.setMoney(business.getMoney()+info.getMoney());
        DDbusinessMapper.updateByPrimaryKey(business);
        return 0;
    }
}
