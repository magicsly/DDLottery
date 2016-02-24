package com.ddlottery.aop;
import com.ddlottery.exception.loginException;
import com.ddlottery.service.DDbusinessService;
import com.ddlottery.service.DDuserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
/**
 * Created by ElNino on 16/1/28.
 */
@Component
@Aspect
public class userLoginAop {
    @Pointcut("execution(* com.ddlottery.service.DDuserService.editUser(..)) ||" +
            "execution(* com.ddlottery.service.DDorderService.addorder(..))")
    public void isLogin() {}

    @Pointcut("execution(* com.ddlottery.service.DDbusinessService.businessInfo(..)) ||" +
            "execution(* com.ddlottery.service.DDbusinessService.businessType(..))")
    public void businessLogin() {}

    @Before("isLogin()")
    public void before(JoinPoint joinPoint) throws loginException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookie = request.getCookies();
        String uid = "";
        String key = "";
        if(cookie == null){
            throw new loginException(-1,"用户未登录");
        }
        for (Cookie c : cookie){
            if(c.getName().equals("uid")){
                uid = c.getValue().toString();
            }
            if(c.getName().equals("key")){
                key = c.getValue().toString();
            }
        }
        String newkey = DigestUtils.md5Hex(uid + DDuserService.key);
        if(!key.equals(newkey)){
            throw new loginException(-1,"用户未登录");
        }
    }

    @Before("businessLogin()")
    public void businessbefore(JoinPoint joinPoint) throws loginException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookie = request.getCookies();
        String bid = "";
        String key = "";
        if(cookie == null){
            throw new loginException(-1,"商户未登录");
        }
        for (Cookie c : cookie){
            if(c.getName().equals("Bid")){
                bid = c.getValue().toString();
            }
            if(c.getName().equals("Bkey")){
                key = c.getValue().toString();
            }
        }
        String newkey = DigestUtils.md5Hex(bid + DDbusinessService.Bkey);
        if(!key.equals(newkey)){
            throw new loginException(-1,"商户未登录");
        }
    }

}
