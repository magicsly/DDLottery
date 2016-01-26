package com.ddlottery.service;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.model.DDorder;
import com.ddlottery.dao.DDorderMapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * Created by ElNino on 16/1/22.
 */
@Service
public class DDorderService {

    @Autowired
    DDorderMapper DDorderMapper;

    @Autowired
    DDbusinessService DDbusinessService;

    public Integer addorder(DDorder order){
        order.setCreattime(new Date());
        order.setState((byte)0);
        DDorderMapper.insertSelective(order);
        return 0;
    }

    public Map machineGetOrder(String mobile , String md5Code){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer bid = DDbusinessService.machLogin(mobile,md5Code);
        if(bid != -1){
            DDorder order = new DDorder();
            order.setBid(bid);
            order.setState((byte)2);
            PageBounds pageBounds = new PageBounds(1,100);
            ArrayList list = DDorderMapper.selectByOther(order,pageBounds);
            map.put("code",0);
            map.put("list",list);
            return map;
        }else {
            map.put("code",-1);
            return map;
        }
    }

    public Integer machinePrintOrder(Integer oid, String md5Code){
        String str = DigestUtils.md5Hex(oid.toString() + DDbusinessService.md5key);
        if(str.equals(md5Code)){
            DDorder order = new DDorder();
            order.setOid(oid);
            order.setState((byte)9);
            order.setPrinttime(new Date());
            DDorderMapper.updateByPrimaryKeySelective(order);
            return 0;
        }else {
            return 1;
        }
    }
}
