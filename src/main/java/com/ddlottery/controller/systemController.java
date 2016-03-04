package com.ddlottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/2/19.
 */
@Controller
@RequestMapping("/")
public class systemController {

    @RequestMapping(value = "/version")
    @ResponseBody
    public Map version(){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer id = 1;
        double v = 1.00;
        String url = "http://www.91bo.com/android/app-user.apk";
        map.put("vcode",id);
        map.put("vname",v);
        map.put("url",url);
        return map;
    }

    @RequestMapping(value = "/bversion")
    @ResponseBody
    public Map bversion(){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer id = 1;
        double v = 1.00;
        String url = "http://www.91bo.com/android/app-business.apk";
        map.put("vcode",id);
        map.put("vname",v);
        map.put("url",url);
        return map;
    }
}
