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

import java.io.IOException;
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
     * @param state (0保存订单，2打印订单)
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
                        @RequestParam(value="state",defaultValue = "",required=false) byte state,
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
        order.setIsprint((byte)0);
        order.setState(state);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
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

    @RequestMapping(value = "/userorderlist")
    @ResponseBody
    public Map userorder_list(@CookieValue(value="uid",defaultValue = "",required=false) Integer uid,
                              @RequestParam(value="print",defaultValue = "",required=false) float print,
                         @RequestParam(value="page",defaultValue = "",required=false) Integer page
    ) throws Exception {
        DDorder order = new DDorder();
        order.setUid(uid);
        order.setIsprint((byte)print);
        Map<String,Object> map = DDorderService.orderList(order, page);
        return map;
    }

    @RequestMapping(value = "/userorderprint")
    @ResponseBody
    public Map userorderprint(@RequestParam(value="oid",defaultValue = "",required=false) Integer oid,
                          @RequestParam(value="bid",defaultValue = "",required=false) Integer bid
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        Integer code = DDorderService.userPrintOrder(oid,bid);
        map.put("code",code);
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
    public Map orderinfo(@RequestParam(value="oid",defaultValue = "",required=false) Integer oid
    ) throws IOException {
        Map map = DDorderService.orderInfo(oid);
        return map;
    }

}
