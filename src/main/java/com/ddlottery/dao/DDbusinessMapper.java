package com.ddlottery.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ddlottery.model.DDbusiness;

import java.util.ArrayList;
import java.util.Map;

public interface DDbusinessMapper {
    int deleteByPrimaryKey(Integer bid);

    int insert(DDbusiness record);

    int insertSelective(DDbusiness record);

    DDbusiness selectByPrimaryKey(Integer bid);

    DDbusiness selectByMobile(String mobile);

    int updateByPrimaryKeySelective(DDbusiness record);

    int updateByPrimaryKey(DDbusiness record);

    ArrayList<DDbusiness> selectBusiness(DDbusiness record,PageBounds pageBounds);

    ArrayList<Map> nearBusiness(DDbusiness record,PageBounds pageBounds);

    int editPwd(DDbusiness record);

}