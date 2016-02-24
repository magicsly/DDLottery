package com.ddlottery.dao;

import com.ddlottery.model.DDcoupon;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface DDcouponMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(DDcoupon record);

    int insertSelective(DDcoupon record);

    DDcoupon selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(DDcoupon record);

    int updateByPrimaryKey(DDcoupon record);

    ArrayList<Map> selectByBid(Integer bid);

    ArrayList<DDcoupon> selectAll(PageBounds pageBounds);

    ArrayList<DDcoupon> businessAll(Map map ,PageBounds pageBounds);

    int selectFullmuchCount(DDcoupon record);

}