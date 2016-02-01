package com.ddlottery.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddlottery.model.DDorder;
import com.ddlottery.service.DDorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/1/22.
 */
@Controller
@RequestMapping("/")
public class orderController {

    @Autowired
    DDorderService DDorderService;

    /**
     * 添加订单
     * @param uid 用户id
     * @param bid 商户id
     * @param lot 彩种id
     * @param play 玩法id
     * @param num 注数
     * @param multiple 倍数
     * @param money 金额
     * @param str 投注串
     * @param content 投注场次id（2016001，2016002，2016003）
     * @param closetime 截止时间
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/addorder")
    @ResponseBody
    public Map addorder(@CookieValue(value="uid",defaultValue = "",required=false) Integer uid,
                        @RequestParam(value="bid",defaultValue = "",required=false) Integer bid,
                        @RequestParam(value="lot",defaultValue = "",required=false) Integer lot,
                        @RequestParam(value="play",defaultValue = "",required=false) Integer play,
                        @RequestParam(value="num",defaultValue = "",required=false) Integer num,
                        @RequestParam(value="multiple",defaultValue = "",required=false) Integer multiple,
                        @RequestParam(value="money",defaultValue = "",required=false) Float money,
                        @RequestParam(value="str",defaultValue = "",required=false) String str,
                        @RequestParam(value="content",defaultValue = "",required=false) String content,
                        @RequestParam(value="closetime",defaultValue = "",required=false) String closetime
    ) throws ParseException {
        DDorder order = new DDorder();
        order.setUid(uid);
        order.setBid(bid);
        order.setLot(lot);
        order.setPlay(play);
        order.setNum(num);
        order.setMultiple(multiple);
        order.setMoney(money);
        order.setStr(str);
        order.setContent(content);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date closedate = sdf.parse(closetime);
        order.setClosetime(closedate);
        Integer code = DDorderService.addorder(order);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",code);
        return map;
    }

    @RequestMapping(value = "/machorder")
    @ResponseBody
    public Map machorder(@RequestParam(value="bid",defaultValue = "",required=false) Integer bid,
                         @RequestParam(value="key",defaultValue = "",required=false) String key
    ) throws Exception {
        Map<String,Object> map = DDorderService.machineGetOrder(bid,key);
        return map;

    }

    @RequestMapping(value = "/userorder_list")
    @ResponseBody
    public Map userorder_list(@CookieValue(value="uid",defaultValue = "",required=false) Integer uid,
                              @RequestParam(value="page",defaultValue = "",required=false) byte print,
                         @RequestParam(value="page",defaultValue = "",required=false) Integer page
    ) throws Exception {
        DDorder order = new DDorder();
        order.setUid(uid);
        order.setIsprint(print);
        Map<String,Object> map = DDorderService.orderList(order, page);
        return map;

    }

    @RequestMapping(value = "/orderprint")
    @ResponseBody
    public Map orderprint(@RequestParam(value="oid",defaultValue = "",required=false) Integer oid,
                         @RequestParam(value="key",defaultValue = "",required=false) String key
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        Integer code = DDorderService.machinePrintOrder(oid,key);
        map.put("code",code);
        return map;
    }


    @RequestMapping(value = "/orderinfo")
    @ResponseBody
    public JSONObject orderinfo() {
        String str = "{\n" +
                "\"username\":\"少保罗成\",\n" +
                "\"lottype\":\"01\",\n" +
                "\"issue\":\"20160129\",\n" +
                "\"proid\":\"16026SS74975\",\n" +
                "\"addtime\":\"2016-01-29 10:55:00\",\n" +
                "\"promoney\":\"60\",\n" +
                "\"multiply\":\"2\",\n" +
                "\"basemoney\":\"2\",\n" +
                "\"state\":\"1\",\n" +
                "\"issuc\":\"1\",\n" +
                "\"buystop\":\"0\",\n" +
                "\"code\":\"HH|SPF>160129002=3,RQSPF>160129003=2,SPF>160129004=0|2*1\",\n" +
                "\"match\":\n" +
                "   [{\"id\":\"160129002\",\n" +
                "   \"oid\":\"周五002\",\n" +
                "   \"home\":\"卡塔尔\",\n" +
                "   \"visit\":\"伊拉克\",\n" +
                "   \"point\":\"－1\",\n" +
                "   },\n" +
                "   {\"id\":\"160129003\",\n" +
                "   \"oid\":\"周五003\",\n" +
                "   \"home\":\"南锡\",\n" +
                "   \"visit\":\"克莱蒙\",\n" +
                "   \"point\":\"2\",\n" +
                "   },\n" +
                "   {\"id\":\"160129004\",\n" +
                "   \"oid\":\"周五004\",\n" +
                "   \"home\":\"伊维恩\",\n" +
                "   \"visit\":\"梅斯\",\n" +
                "   \"point\":\"－1\",\n" +
                "   }]\n" +
                "}";
        return JSON.parseObject(str);
    }

}
