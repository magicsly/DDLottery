package com.ddlottery.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by ElNino on 16/2/25.
 */
@Controller
@RequestMapping("/")
public class systemPage {

    @RequestMapping("adminlogin")
    public ModelAndView adminlogin(String name,String pwd ,ModelAndView modelAndView){
        if(name ==null){
            return modelAndView;
        }
        if(pwd ==null){
            return modelAndView;
        }
        if(name.equals("admin") && pwd.equals("cpdyj1234")){
            HttpSession session = getSession();
            session.setAttribute("admin", "admin");
            modelAndView.setViewName("redirect:index");
        }else {
            modelAndView.addObject("isok","error");
        }
        return modelAndView;
    }

    @RequestMapping("adminlogout")
    public ModelAndView adminlogout(ModelAndView modelAndView){
        HttpSession session = getSession();
        session.invalidate();
        modelAndView.setViewName("redirect:adminlogin");
        return modelAndView;
    }
    public static HttpSession getSession() {
        HttpSession session = null;
        try {
            session = getRequest().getSession();
        } catch (Exception e) {}
        return session;
    }
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return attrs.getRequest();
    }

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView){

        return modelAndView;
    }
}
