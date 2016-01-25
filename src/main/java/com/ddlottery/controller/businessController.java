package com.ddlottery.controller;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.service.DDbusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/1/22.
 */
@Controller
@RequestMapping("/")
public class businessController {
    @Autowired
    DDbusinessService DDbusinessService;

    @RequestMapping(value = "/addbusiness")
    @ResponseBody
    public Map addbusiness(@RequestParam(value="mobile",defaultValue = "",required=false) String mobile){
        DDbusiness business = new DDbusiness();
        Integer code = DDbusinessService.addBusiness(business);
        Map<String,Object> map = new HashMap<String, Object>();

        return map;
    }
}
