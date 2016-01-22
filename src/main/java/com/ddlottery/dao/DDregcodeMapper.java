package com.ddlottery.dao;

import com.ddlottery.model.DDregcode;
import org.springframework.stereotype.Repository;

@Repository
public interface DDregcodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DDregcode record);

    int insertSelective(DDregcode record);

    DDregcode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DDregcode record);

    int updateByPrimaryKey(DDregcode record);

    int selectcode(DDregcode record);

    int updateCode(DDregcode record);

}