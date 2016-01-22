package com.ddlottery.tools;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by ElNino on 16/1/21.
 */
public class tools {

    public void PostSms(String mobile,String msg) throws IOException {
        String url = "http://user.cpdyj.com/user/insertSMS.go?type=printorder&mobile="+mobile+"&code="+msg;
        Document doc = Jsoup.connect(url).get();
    }
}
