package com.ddlottery.dao;

import com.ddlottery.model.DDbusiness;

public interface DDbusinessMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(DDbusiness record);

    int insertSelective(DDbusiness record);

    DDbusiness selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(DDbusiness record);

    int updateByPrimaryKey(DDbusiness record);
}