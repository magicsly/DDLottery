package com.ddlottery.page;

import com.ddlottery.model.DDadmin;
import com.ddlottery.service.DDadminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by ElNino on 16/3/1.
 */
@Controller
@RequestMapping("/")
public class adminPage {
    @Autowired
    DDadminService DDadminService;

    @RequestMapping("admin_list")
    public ModelAndView business_list(Integer page, ModelAndView modelAndView){
        if(page == null){
            page = 1;
        }
        Map adminListMap = DDadminService.admin_list(page);
        modelAndView.addObject("adminList", adminListMap.get("list"));
        modelAndView.addObject("count",adminListMap.get("count"));
        modelAndView.addObject("page",adminListMap.get("page"));
        return modelAndView;
    }
}
