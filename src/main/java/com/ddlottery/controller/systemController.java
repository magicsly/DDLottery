package com.ddlottery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by ElNino on 16/2/19.
 */
@Controller
@RequestMapping("/")
public class systemController {

    @RequestMapping(value = "/version")
    @ResponseBody
    public String version(){
        return "1.0.0";
    }
}
