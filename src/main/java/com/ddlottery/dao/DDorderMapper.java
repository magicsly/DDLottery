package com.ddlottery.dao;

import com.ddlottery.model.DDorder;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.ArrayList;

public interface DDorderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(DDorder record);

    int insertSelective(DDorder record);

    DDorder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(DDorder record);

    int updateByPrimaryKey(DDorder record);

    ArrayList<DDorder> selectByOther(DDorder record,PageBounds pageBounds);
}