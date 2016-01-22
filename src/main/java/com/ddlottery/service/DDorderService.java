package com.ddlottery.service;

import com.ddlottery.model.DDorder;
import com.ddlottery.dao.DDorderMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;

/**
 * Created by ElNino on 16/1/22.
 */
@Service
public class DDorderService {

    @Autowired
    DDorderMapper DDorderMapper;

    public Integer addorder(DDorder order){
        order.setCreattime(new Date());
        DDorderMapper.insertSelective(order);
        return 0;
    }

}
