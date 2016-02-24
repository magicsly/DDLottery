package com.ddlottery.dao;

import com.ddlottery.model.DDcouponInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.ArrayList;
import java.util.Map;

public interface DDcouponInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DDcouponInfo record);

    int insertSelective(DDcouponInfo record);

    DDcouponInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DDcouponInfo record);

    int updateByPrimaryKey(DDcouponInfo record);

    DDcouponInfo selectByCodenum(String codenum);

    ArrayList<Map> selectByUidNow(Integer uid);

    ArrayList<Map> selectByUidAfter(Integer uid);

    ArrayList<Map> selectByCid(Integer cid,PageBounds pageBounds);

    Map selectInfo(Integer id);

    Map couponByCode(String codenum);

    ArrayList<Map> useCouponByBid(DDcouponInfo record,PageBounds pageBounds);

    Integer selectCountByCid(Map map);

}