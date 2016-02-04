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

    public Integer addCoupon(DDcoupon coupon){
        coupon.setCreattime(new Date());
        DDcouponMapper.insertSelective(coupon);
        return 0;
    }

    public Integer receiveCoupon(Integer cid,Integer uid) throws Exception {
        DDcoupon coupon= DDcouponMapper.selectByPrimaryKey(cid);
        Date now = new Date();
        if(coupon.getEndtime().getTime()>now.getTime()){
            Integer num = coupon.getNum()-1;
            if(num<0){
                return 2;
            }
            coupon.setNum(num);
            DDcouponMapper.updateByPrimaryKeySelective(coupon);
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
            Integer ciid = DDcouponInfoMapper.insertSelective(info);
            String code = md5_16.md5(ciid.toString());
            info.setCodenum(code);
            return DDcouponInfoMapper.updateByPrimaryKeySelective(info);
        }else {
            return 1;
        }
    }

    //public Integer useCoupon(Integer )
}
