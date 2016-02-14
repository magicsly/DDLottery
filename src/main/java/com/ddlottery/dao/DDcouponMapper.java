package com.ddlottery.dao;

import com.ddlottery.model.DDcoupon;

import java.util.ArrayList;
import java.util.Map;

public interface DDcouponMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(DDcoupon record);

    int insertSelective(DDcoupon record);

    DDcoupon selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(DDcoupon record);

    int updateByPrimaryKey(DDcoupon record);

    ArrayList<Map> selectByBid(Integer bid);

}