package com.ddlottery.dao;

import com.ddlottery.model.DDorder;

public interface DDorderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(DDorder record);

    int insertSelective(DDorder record);

    DDorder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(DDorder record);

    int updateByPrimaryKey(DDorder record);
}