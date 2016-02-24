package com.ddlottery.page;

import com.ddlottery.dao.DDuserMapper;
import com.ddlottery.service.DDuserService;
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
public class userPage {

    @Autowired
    DDuserService DDuserService;

    @RequestMapping("user_list")
    public ModelAndView user_list(Integer page,ModelAndView modelAndView){
        if(page == null){
            page = 1;
        }
        Map businessListMap = DDuserService.userList(page);
        modelAndView.addObject("userList",businessListMap.get("list"));
        modelAndView.addObject("count",businessListMap.get("count"));
        modelAndView.addObject("page",businessListMap.get("page"));
        return modelAndView;
    }
}
