package com.ddlottery.tools;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
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
        ss.setUsername("652678");
        ss.setPassword("f8d3d865051a71a037881c86e94c1881");
        ss.setMessage(msg+"【苋菜】");
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

//    public double distHaversineRAD(double lat1, double lon1, double lat2, double lon2) {
//        double hsinX = Math.sin((lon1 - lon2) * 0.5);
//        double hsinY = Math.sin((lat1 - lat2) * 0.5);
//        double h = hsinY * hsinY +
//                (Math.cos(lat1) * Math.cos(lat2) * hsinX * hsinX);
//        return 2 * Math.atan2(Math.sqrt(h), Math.sqrt(1 - h)) * 6367000;
//    }

    private   static double EARTH_RADIUS = 6378.137;//地球半径
    private static double rad(double d)
    {
        return d * Math.PI / 180.0;
    }

    public static double distHaversineRAD(double lat1, double lng1, double lat2, double lng2)
    {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);

        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
//        s = Math.round(s * 10000) / 10000;
        return s;
    }
}
