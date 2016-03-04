package com.ddlottery.service;

import com.ddlottery.dao.DDadminMapper;
import com.ddlottery.model.DDadmin;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/3/1.
 */
@Service
public class DDadminService {

    public static final Integer pageSize = 20;

    @Autowired
    DDadminMapper DDadminMapper;

    public Map admin_list(Integer page){
        Map<String, Object> map = new HashMap<String, Object>();
        PageBounds pageBounds = new PageBounds(page,pageSize);
        ArrayList list = DDadminMapper.selectAll(pageBounds);
        PageList pageList = (PageList)list;
        map.put("code",0);
        map.put("list",list);
        map.put("count",pageList.getPaginator().getTotalCount());
        map.put("pagesize",pageSize);
        map.put("page",page);
        return map;
    }
}
