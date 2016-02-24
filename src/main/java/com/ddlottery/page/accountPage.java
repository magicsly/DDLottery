package com.ddlottery.page;

import com.ddlottery.service.DDaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by ElNino on 16/2/19.
 */
@Controller
@RequestMapping("/")
public class accountPage {
    @Autowired
    DDaccountService DDaccountService;

    @RequestMapping("draw_list")
    public ModelAndView draw_list(Integer page,ModelAndView modelAndView){
        if(page == null){
            page = 1;
        }
        Map businessListMap = DDaccountService.DrawList(page);
        modelAndView.addObject("drawList",businessListMap.get("list"));
        modelAndView.addObject("count",businessListMap.get("count"));
        modelAndView.addObject("page",businessListMap.get("page"));
        return modelAndView;
    }
}
