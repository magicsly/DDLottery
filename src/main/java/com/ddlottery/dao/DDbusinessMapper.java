package com.ddlottery.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ddlottery.model.DDbusiness;

import java.util.ArrayList;

public interface DDbusinessMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(DDbusiness record);

    int insertSelective(DDbusiness record);

    DDbusiness selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(DDbusiness record);

    int updateByPrimaryKey(DDbusiness record);

    ArrayList<DDbusiness> selectBusiness(PageBounds pageBounds);

}