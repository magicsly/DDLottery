package com.ddlottery.service;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.dao.DDbusinessMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by ElNino on 16/1/22.
 */
@Service
public class DDbusinessService {
    @Autowired
    DDbusinessMapper DDbusinessMapper;
    public Integer addorder(DDbusiness business){
        business.setCreattime(new Date());
        business.setState((byte)0);
        DDbusinessMapper.insertSelective(business);
        return 0;
    }
}

