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

    public Integer receiveCoupon(Integer cid,Integer uid){
        DDcoupon coupon= DDcouponMapper.selectByPrimaryKey(cid);
        Date now = new Date();
        if(coupon.getEndtime().getTime()>now.getTime()){
            DDuser user = DDuserMapper.selectByPrimaryKey(uid);
            DDbusiness business = DDbusinessMapper.selectByPrimaryKey(coupon.getBid());
            DDcouponInfo info = new DDcouponInfo();
            info.setBid(coupon.getBid());
            info.setIsuse((byte)0);
            info.setEndtime(coupon.getEndtime());
            info.setStarttime(new Date());
            info.setCid(coupon.getCid());
            info.setBname(business.getLocname());
            info.setBmobile(business.getMobile());
            info.setUname(user.getMobile());
            DDcouponInfoMapper.insertSelective(info);
            return 0;
            //info.setCodenum();
        }else {
            return 1;
        }
    }
}
