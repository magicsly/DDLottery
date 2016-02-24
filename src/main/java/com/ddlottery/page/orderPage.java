package com.ddlottery.page;

import com.ddlottery.model.DDorder;
import com.ddlottery.service.DDorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by ElNino on 16/2/17.
 */
@Controller
@RequestMapping("/")
public class orderPage {
    @Autowired
    DDorderService DDorderService;

    @RequestMapping("order_list")
    public ModelAndView order_list(Integer page,ModelAndView modelAndView){
        if(page == null){
            page = 1;
        }
        Map businessListMap = DDorderService.orderList(new DDorder(),page);
        modelAndView.addObject("orderList",businessListMap.get("list"));
        modelAndView.addObject("count",businessListMap.get("count"));
        modelAndView.addObject("page",businessListMap.get("page"));
        return modelAndView;
    }

}
