package com.ddlottery.aop;

import com.ddlottery.exception.loginException;
import com.ddlottery.service.DDuserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ElNino on 16/2/25.
 */
@Component
@Aspect
public class systemAop {
    @Pointcut("execution(* com.ddlottery.page.businessPage.business_list(..)) ||" +
            "execution(* com.ddlottery.page.businessPage.business_info(..))")
    public void adminlogin() {}

    @Before("adminlogin()")
    public void before(JoinPoint joinPoint) throws loginException {

    }
}
