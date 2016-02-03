package com.ddlottery.dao;

import com.ddlottery.model.DDuser;
import org.springframework.stereotype.Repository;

@Repository
public interface DDuserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(DDuser record);

    int insertSelective(DDuser record);

    DDuser selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(DDuser record);

    int updateByPrimaryKey(DDuser record);

    DDuser userlogin(DDuser record);

    DDuser selectbyuid(DDuser record);

    int isuser (String mobile);

    int editPwd(DDuser record);
}