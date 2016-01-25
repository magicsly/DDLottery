package com.ddlottery.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ddlottery.model.DDuser;
import com.ddlottery.model.DDregcode;
import com.ddlottery.dao.DDuserMapper;
import com.ddlottery.dao.DDregcodeMapper;
import com.ddlottery.tools.tools;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by ElNino on 16/1/20.
 */
@Service
public class DDuserService {

    public static final String SESSION_USERNAME = "username";
    public static final String SESSION_UID = "uid";
    public static final String SESSION_MOBILE = "mobile";
    public static final String key = "1234567";

    @Autowired
    DDuserMapper DDuserMapper;
    @Autowired
    DDregcodeMapper DDregcodeMapper;

    tools tools = new tools();
    public Integer PostRegCode(String mobile,String ip) throws IOException {
        java.util.Random random=new java.util.Random();
        String code=random.nextInt(10)+""+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10)+random.nextInt(10);
        DDregcode regcode = new DDregcode();
        regcode.setCode(code);
        regcode.setMobile(mobile);
        Date date = new Date();
        Date date2 = new Date();
        regcode.setCreattime(date);
        date2.setHours(new Date().getHours()+1);
        regcode.setClosetime(date2);
        regcode.setIp(ip);
        regcode.setIsuse((byte)0);
        DDregcodeMapper.insertSelective(regcode);
        tools.PostSms(mobile,code);
        return 0;
    }

    public Integer RegUser(DDuser user,String code){
        DDregcode regcode = new DDregcode();
        regcode.setMobile(user.getMobile());
        regcode.setIp(user.getIp());
        regcode.setCode(code);
        regcode.setClosetime(new Date());
        Integer isreg = DDregcodeMapper.selectcode(regcode);
        if(isreg == 0){
            return 9001;//验证码错误
        }
        Integer userConf = confUser(user,0);
        if(userConf == 0){
            String md5pw = DigestUtils.md5Hex(user.getPwd());
            user.setPwd(md5pw);
            user.setCreattime(new Date());
            DDuserMapper.insertSelective(user);
            regcode.setUsetime(new Date());
            DDregcodeMapper.updateCode(regcode);
            return 0;
        }else{
            return userConf;
        }
    }

    public Integer confUser(DDuser user , Integer type) {
        Integer code = 0;
        if (type == 0){//如果是注册,检查用户名和密码
            if (!user.getMobile().matches("^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$")) {
                code = 1001;
            }
            Integer isuser = DDuserMapper.isuser(user.getMobile());
            if(isuser > 0) {//用户名存在
                code = 1002;
            }
            //验证密码
            if(user.getPwd()==""){
                code = 2001;
            }else if(user.getPwd().length() > 20){
                code = 2002;
            }else if(user.getPwd().length() < 6){
                code = 2003;
            }
        }
        return code;
    }

    public Integer login(DDuser user,HttpServletRequest request,HttpServletResponse response){
        try {
            String md5pw =DigestUtils.md5Hex(user.getPwd());
            user.setPwd(md5pw);
            DDuser reqUser = DDuserMapper.userlogin(user);
            if(reqUser.getUid() != null){
                request.getSession().setAttribute(SESSION_UID,reqUser.getUid());
                request.getSession().setAttribute(SESSION_MOBILE,user.getMobile());
                Cookie cookie = new Cookie("uid", reqUser.getUid().toString());
                Cookie cookie2 = new Cookie("key", DigestUtils.md5Hex(reqUser.getUid().toString()+key));
                response.addCookie(cookie);
                response.addCookie(cookie2);
                return reqUser.getUid();
            }else {
                return -1;
            }
        }catch (Exception e){
            return -1;
        }
    }

    public Integer editUser(DDuser user){
        try {
            Integer code = confUser(user,1);
            if(code == 0){
                DDuserMapper.updateByPrimaryKeySelective(user);
            }
            return code;
        }catch (Exception e){
            return -1;
        }
    }

    public Integer iscode(String mobile,String code){
        DDregcode regcode = new DDregcode();
        regcode.setMobile(mobile);
        regcode.setCode(code);
        regcode.setClosetime(new Date());
        Integer isreg = DDregcodeMapper.selectcode(regcode);
        if(isreg == 0){
            return 9001;//验证码错误
        }else{
            regcode.setUsetime(new Date());
            DDregcodeMapper.updateCode(regcode);
            return 0;
        }
    }

}

