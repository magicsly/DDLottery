package com.ddlottery.service;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.dao.DDbusinessMapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by ElNino on 16/1/22.
 */
@Service
public class DDbusinessService {
    @Autowired
    DDbusinessMapper DDbusinessMapper;

    public static final Integer pageSize = 20;

    public Integer addBusiness(DDbusiness business){
        business.setCreattime(new Date());
        business.setState((byte)0);
        DDbusinessMapper.insertSelective(business);
        return 0;
    }

    public List business_list(Integer page){
        PageBounds pageBounds = new PageBounds(page,pageSize);
        List<DDbusiness> list = DDbusinessMapper.selectBusiness(pageBounds);
        return list;
    }
}

