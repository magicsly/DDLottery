package com.ddlottery.controller;

import com.ddlottery.service.DDcouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/2/3.
 */
@Controller
@RequestMapping("/")
public class couponController {
    @Autowired
    DDcouponService DDcouponService;

    /****
     * 领取优惠券
     * @param uid
     * @param cid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/receivecoupon")
    @ResponseBody
    public Map receivecoupon(@CookieValue(value="uid",defaultValue = "",required=false) Integer uid,
                             @RequestParam(value="cid",defaultValue = "",required=false) Integer cid
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        Integer code = DDcouponService.receiveCoupon(cid, uid);
        map.put("code",code);
        return map;
    }

    /****
     * 核销优惠券
     * @param code
     * @param bid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/usecoupon")
    @ResponseBody
    public Map usecoupon(@RequestParam(value="code",defaultValue = "",required=false) String code,
                             @RequestParam(value="bid",defaultValue = "",required=false) Integer bid
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        Integer msgcode = DDcouponService.useCoupon(code,bid);
        map.put("code",msgcode);
        return map;
    }

    @RequestMapping(value = "/couponbybid")
    @ResponseBody
    public Map couponbybid(@RequestParam(value="bid",defaultValue = "",required=false) Integer bid
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        ArrayList list = DDcouponService.couponBybid(bid);
        map.put("code",0);
        map.put("list",list);
        return map;
    }


    @RequestMapping(value = "/couponbyuid")
    @ResponseBody
    public Map couponbyuid(@CookieValue(value="uid",defaultValue = "",required=false) Integer uid
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        ArrayList list = DDcouponService.couponBybid(uid);
        map.put("code",0);
        map.put("list",list);
        return map;
    }

}
