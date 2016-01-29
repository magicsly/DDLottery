package com.ddlottery.controller;

import com.ddlottery.exception.loginException;
import com.ddlottery.model.loginError;
import com.ddlottery.tools.uploadFiles;
import org.mybatis.spring.MyBatisExceptionTranslator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.logging.Logger;
/**
 * Created by ElNino on 16/1/28.
 */
@Controller
@RequestMapping("/")
public class baseController {
    Logger logger= Logger.getLogger(baseController.class.getName());

    @ExceptionHandler
    public @ResponseBody loginError exp(HttpServletRequest request, Exception ex) {
        if(ex instanceof loginException){
            loginException myException = (loginException) ex;
            return myException.getError();
        }
        logger.info(ex.getMessage());
        return new loginError(-9,ex.getMessage());
    }

}
