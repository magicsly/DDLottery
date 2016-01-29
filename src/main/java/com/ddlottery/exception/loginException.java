package com.ddlottery.exception;

import com.ddlottery.model.loginError;

/**
 * Created by ElNino on 16/1/28.
 */
public class loginException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private loginError error ;

    public loginException(String message){
        this(-9,message);
    }

    public loginException(int code ,String message){
        error = new loginError(code,message);
    }

    public loginError getError(){
        return error;
    }
}
