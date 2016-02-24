package com.ddlottery.dao;

import com.ddlottery.model.DDaccount;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.ArrayList;
import java.util.Map;

public interface DDaccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DDaccount record);

    int insertSelective(DDaccount record);

    DDaccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DDaccount record);

    int updateByPrimaryKey(DDaccount record);

    ArrayList<Map> selectByBid(Integer bid,PageBounds pageBounds);
}