package com.ddlottery.model;

/**
 * Created by ElNino on 16/1/28.
 */
public class loginError {
    private int code = 0;
    private String message = "";

    public loginError(){
    }

    public loginError(String message) {
        this.message = message;
    }

    public loginError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
