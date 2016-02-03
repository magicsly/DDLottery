package com.ddlottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/2/3.
 */
@Controller
@RequestMapping("/")
public class couponController {

    @RequestMapping(value = "/receivecoupon")
    @ResponseBody
    public Map receivecoupon(@CookieValue(value="uid",defaultValue = "",required=false) Integer uid,
                             @RequestParam(value="cid",defaultValue = "",required=false) Integer cid
    ){
        Map<String,Object> map = new HashMap<String, Object>();
        return map;
    }


}
