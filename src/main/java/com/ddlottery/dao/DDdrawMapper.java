package com.ddlottery.dao;

import com.ddlottery.model.DDdraw;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.ArrayList;
import java.util.Map;

public interface DDdrawMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DDdraw record);

    int insertSelective(DDdraw record);

    DDdraw selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DDdraw record);

    int updateByPrimaryKey(DDdraw record);

    ArrayList<Map> selectByBid(Integer bid,PageBounds pageBounds);

    ArrayList<Map> selectAll(PageBounds pageBounds);
}