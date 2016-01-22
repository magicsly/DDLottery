package com.ddlottery.controller;

import com.ddlottery.model.DDuser;
import com.ddlottery.service.DDuserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/1/21.
 */
@Controller
@RequestMapping("/")
public class userController {
    @Autowired
    DDuserService DDuserService;

    @RequestMapping(value = "/postcode")
    @ResponseBody
    public Map postcode(@RequestParam(value="mobile",defaultValue = "",required=false) String mobile,
                        HttpServletRequest request) throws IOException {
        Integer code = DDuserService.PostRegCode(mobile, request.getRemoteAddr());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code", code);
        return map;
    }

    @RequestMapping(value = "/regrist")
    @ResponseBody
    public Map regrist(@RequestParam(value="mobile",defaultValue = "",required=false) String mobile,
                       @RequestParam(value="pwd",defaultValue = "",required=false) String pwd,
                       @RequestParam(value="code",defaultValue = "",required=false) String code
    ) {
        DDuser user = new DDuser();
        user.setMobile(mobile);
        user.setPwd(pwd);
        Integer regcode = DDuserService.RegUser(user,code);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code", regcode);
        return map;
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public Map login(@RequestParam(value="mobile",defaultValue = "",required=false) String mobile,
                     @RequestParam(value="pwd",defaultValue = "",required=false) String pwd,
                     HttpServletRequest request,HttpServletResponse response
    ){
        DDuser user = new DDuser();
        user.setMobile(mobile);
        user.setPwd(pwd);
        Integer code = DDuserService.login(user,request,response);
        Map<String,Object> map = new HashMap<String, Object>();
        if(code>=0) {
            map.put("code", 0);
            map.put("uid", code);
        }else {
            map.put("code", "-1");
            map.put("msg", "登录失败");
        }
        return map;
    }
    @RequestMapping(value = "/islogin")
    @ResponseBody
    public Map islogin(@CookieValue(value = "uid",defaultValue = "",required=false) Integer uid
    ){
        Map<String,Object> map = new HashMap<String, Object>();
        if(uid==null) {
            map.put("code", -1);
            map.put("msg", "未登录");
        }else {
            map.put("code", 0);
            map.put("msg", "已登录");
        }
        return map;
    }

    @RequestMapping(value = "/edituser")
    @ResponseBody
    public Map edituser(@RequestParam(value="uid",defaultValue = "",required=false) Integer uid,
                        @RequestParam(value="nickname",defaultValue = "",required=false) String nickname,
                        @RequestParam(value="bigimage",defaultValue = "",required=false) String bigimage,
                        @RequestParam(value="smallimage",defaultValue = "",required=false) String smallimage
    ) {

        DDuser user = new DDuser();
        user.setUid(uid);
        user.setNickname(nickname);
        user.setBigimg(bigimage);
        user.setSmallimg(smallimage);
        Integer code = DDuserService.editUser(user);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",code);
        return map;
    }

}
