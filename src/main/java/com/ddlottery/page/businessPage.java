package com.ddlottery.page;

import com.ddlottery.service.DDbusinessService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by ElNino on 16/2/1.
 */
@Controller
@RequestMapping("/")
public class businessPage {
    @Autowired
    com.ddlottery.service.DDbusinessService DDbusinessService;

    @RequestMapping("business_order")
    public ModelAndView md5(String bid,ModelAndView modelAndView){
        String codes = DigestUtils.md5Hex(bid + DDbusinessService.md5key);
        modelAndView.addObject("md5", codes);
        return modelAndView;
    }

    @RequestMapping("business_list")
    public ModelAndView business_list(ModelAndView modelAndView){
        Map businessListMap = DDbusinessService.business_list(1);
        modelAndView.addObject("businessList",businessListMap.get("list"));
        return modelAndView;
    }

    @RequestMapping("business_info")
    public ModelAndView business_info(ModelAndView modelAndView){
        return modelAndView;
    }
}
