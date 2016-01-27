package com.ddlottery.service;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.dao.DDbusinessMapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by ElNino on 16/1/22.
 */
@Service
public class DDbusinessService {
    @Autowired
    DDbusinessMapper DDbusinessMapper;

    public String md5key = "123456";
    public static final Integer pageSize = 20;

    public Integer addBusiness(DDbusiness business){
        String md5pw = DigestUtils.md5Hex(business.getPwd());
        business.setPwd(md5pw);
        business.setMoney((float) 0);
        business.setCreattime(new Date());
        business.setState((byte)0);
        DDbusinessMapper.insertSelective(business);
        return 0;
    }

    public Integer machLogin (String mobile , String md5Code){
        DDbusiness business = DDbusinessMapper.selectByMobile(mobile);
        String str = DigestUtils.md5Hex(business.getMobile()+business.getPwd()+md5key);
        if(md5Code.equals("cym")){
            return business.getBid();
        }
        if(str.equals(md5Code)){
            return business.getBid();
        }else {
            return -1;
        }
    }


    public Map business_list(Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDbusinessMapper.selectBusiness(pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }

    public String getMd5key(String mobile){
        DDbusiness business = DDbusinessMapper.selectByMobile(mobile);
        return  DigestUtils.md5Hex(business.getMobile()+business.getPwd()+md5key);
    }
}

