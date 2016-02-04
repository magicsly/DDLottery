package com.ddlottery.dao;

import com.ddlottery.model.DDcoupon;

public interface DDcouponMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(DDcoupon record);

    int insertSelective(DDcoupon record);

    DDcoupon selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(DDcoupon record);

    int updateByPrimaryKey(DDcoupon record);
}