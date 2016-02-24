package com.ddlottery.tools;

import com.alibaba.fastjson.JSON;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by ElNino on 16/1/21.
 */
public class tools {

    public void PostSms(String mobile,String msg) throws IOException {
//        String url = "http://user.cpdyj.com/user/insertSMS.go?type=printorder&mobile="+mobile+"&code="+msg;
//        Document doc = Jsoup.connect(url).get();

        SendSMS ss = new SendSMS();
        ss.setUsername("554148");
        ss.setPassword("e10adc3949ba59abbe56e057f20f883e");
        ss.setMessage(msg);
        ss.setMobiles(mobile);
        ss.setServicesRequestAddRess("http://sms.c8686.com/Api/BayouSmsApiEx.aspx");
        ss.setSmstype(0);
        ss.setTimerid("0");
        ss.setTimertype(0);
        Map<String, String> map = ss.sendSMS();
    }

    public List getMatch(String matchId) throws IOException {
        Document document=Jsoup.connect("http://jc.cpdyj.com/jc/getmatchinfo.go?playId=1&sid="+matchId).get();
        Document d=Jsoup.parse(document.select("xml").toString(), "", Parser.xmlParser());
        Elements e=d.select("row");
        List<Map<String,Object>> maps=new ArrayList<Map<String, Object>>();
        for (Element element:e){
            Attributes attrs = element.attributes();
            Map<String,Object> map=new HashMap<String, Object>();
            for(Attribute attr:attrs){
                map.put(attr.getKey(),attr.getValue());
            }
            maps.add(map);
        }
        return maps;
        //System.out.println(JSON.toJSON(maps));
    }

    public static Date stringToDate(String str) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            // Fri Feb 24 00:00:00 CST 2012
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 2012-02-24
        date = java.sql.Date.valueOf(str);

        return date;
    }
}
