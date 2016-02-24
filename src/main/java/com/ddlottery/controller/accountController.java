package com.ddlottery.controller;

import com.ddlottery.model.DDdraw;
import com.ddlottery.service.DDaccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/2/19.
 */
@Controller
@RequestMapping("/")
public class accountController {

    @Autowired
    DDaccountService  DDaccountService;

    @RequestMapping(value = "/adddraw")
    @ResponseBody
    public Map adddraw(@CookieValue(value="Bid",defaultValue = "",required=false) Integer bid,
                       @RequestParam(value="money",defaultValue = "",required=false) Float money
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        DDdraw draw = new DDdraw();
        draw.setBid(bid);
        draw.setMoney(money);
        Integer code = DDaccountService.addDraw(draw);
        map.put("code",code);
        return map;
    }

    @RequestMapping(value = "/baccount")
    @ResponseBody
    public Map baccount(@CookieValue(value="Bid",defaultValue = "",required=false) Integer bid,
                        @RequestParam(value="page",defaultValue = "1",required=false) Integer page
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        map = DDaccountService.busineeAccountList(bid,page);
        return map;
    }

    @RequestMapping(value = "/drawlist")
    @ResponseBody
    public Map drawlist(@CookieValue(value="Bid",defaultValue = "",required=false) Integer bid,
                        @RequestParam(value="page",defaultValue = "1",required=false) Integer page
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        map = DDaccountService.DrawListByBid(bid,page);
        return map;
    }

    @RequestMapping(value = "/drawstate")
    @ResponseBody
    public Map drawtype(@RequestParam(value="id",defaultValue = "",required=false) Integer id,
                        @RequestParam(value="state",defaultValue = "",required=false) byte state
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        Integer code = DDaccountService.EditDrawState(id,state);
        map.put("code",code);
        return map;
    }
}
