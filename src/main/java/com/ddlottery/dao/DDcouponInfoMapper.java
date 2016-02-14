package com.ddlottery.dao;

import com.ddlottery.model.DDcouponInfo;

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

    ArrayList<Map> selectByUid(Integer uid);
}