package com.ddlottery.controller;

import com.ddlottery.model.DDorder;
import com.ddlottery.service.DDorderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/addorder")
    @ResponseBody
    public Map addorder(@RequestParam(value="uid",defaultValue = "",required=false) Integer uid,
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
}
