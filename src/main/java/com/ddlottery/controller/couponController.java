package com.ddlottery.controller;

import com.ddlottery.model.DDcoupon;
import com.ddlottery.model.DDcouponInfo;
import com.ddlottery.service.DDcouponService;
import com.ddlottery.tools.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
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
     * 添加优惠券
     * @param bid bid
     * @param title 标题
     * @param money 金额
     * @param num 数量
     * @param fullmuch 满多少
     * @param starttime 开始时间
     * @param endtime 结束时间
     * @param limitnum 限领数量
     * @param tips 提示
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addcoupon")
    @ResponseBody
    public Map addcoupon(@CookieValue(value="Bid",defaultValue = "",required=false) Integer bid,
                         @RequestParam(value="title",defaultValue = "",required=false) String title,
                         @RequestParam(value="money",defaultValue = "",required=false) Float money,
                         @RequestParam(value="num",defaultValue = "",required=false) Integer num,
                         @RequestParam(value="fullmuch",defaultValue = "",required=false) Float fullmuch,
                         @RequestParam(value="starttime",defaultValue = "",required=false) String starttime,
                         @RequestParam(value="endtime",defaultValue = "",required=false) String endtime,
                         @RequestParam(value="limitnum",defaultValue = "",required=false) Integer limitnum,
                         @RequestParam(value="tips",defaultValue = "",required=false) String tips

    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        DDcoupon coupon = new DDcoupon();
        coupon.setBid(bid.toString());
        coupon.setTitle(title);
        coupon.setNum(num);
        coupon.setRestnum(num);
        coupon.setUsenum(0);
        coupon.setMoney(money);
        coupon.setFullmuch(fullmuch);
        coupon.setStarttime(tools.stringToDate(starttime));
        coupon.setEndtime(tools.stringToDate(endtime));
        coupon.setLimitnum(limitnum);
        coupon.setTips(tips);
        Integer code = DDcouponService.addCoupon(coupon);
        map.put("code",code);
        return map;
    }

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
                             @CookieValue(value="Bid",defaultValue = "",required=false) Integer bid
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
    public Map couponbyuid(@CookieValue(value="uid",defaultValue = "",required=false) Integer uid,
                           @RequestParam(value="type",defaultValue = "0",required=false) Integer type
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        ArrayList listnow = DDcouponService.couponByuid(uid, 0);
        ArrayList listafter = DDcouponService.couponByuid(uid,1);
        map.put("code",0);
        if(type==0){
            map.put("list",listnow);
        }else{
            map.put("list",listafter);
        }
        return map;
    }

    @RequestMapping(value = "/usercouponinfo")
    @ResponseBody
    public Map couponbyuid(@RequestParam(value="id",defaultValue = "",required=false) Integer id){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",0);
        map.put("info",DDcouponService.userCouponInfo(id));
        return map;
    }

    @RequestMapping(value = "/couponbycode")
    @ResponseBody
    public Map couponbycode(@RequestParam(value="codenum",defaultValue = "",required=false) String codenum){
        Map<String,Object> map = new HashMap<String, Object>();
        Map info = DDcouponService.couponbycode(codenum);
        if(info==null){
            map.put("code", 1);
            map.put("msg","此优惠券不存在");
        }else {
            map.put("code", 0);
            map.put("info", info);
        }
        return map;
    }

    /****
     * 商户优惠券活动列表
     * @param bid
     * @param type 状态 0所有 1领取中 2领完 3结束
     * @param page 分页
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/businesscouponlist")
    @ResponseBody
    public Map businesscouponlist(@CookieValue(value="Bid",defaultValue = "",required=false) Integer bid,
                                  @RequestParam(value="type",defaultValue = "0",required=false) Integer type,
                                  @RequestParam(value="page",defaultValue = "1",required=false) Integer page
    ) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        Map info = DDcouponService.businessCouponList(bid, type,page);
        return info;
    }

    /****
     *
     * @param bid cookies
     * @param code 优惠码(不填写就为所有)
     * @param page 分页
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/couponuselist")
    @ResponseBody
    public Map couponuselist(@CookieValue(value="Bid",defaultValue = "",required=false) Integer bid,
                                  @RequestParam(value="code",defaultValue = "",required=false) String code,
                                  @RequestParam(value="page",defaultValue = "1",required=false) Integer page
    ) throws Exception {
        Map<String,Object> map = DDcouponService.couponUseList(bid,code,page);
        return map;
    }

    @RequestMapping(value = "couponclose")
    @ResponseBody
    public Map business_List(@CookieValue(value="cid",defaultValue = "",required=false) Integer cid,
                             @RequestParam(value="state",defaultValue = "0",required=false) Byte state){
        Map<String,Object> map = new HashMap<String, Object>();
        Integer code = DDcouponService.couponState(cid,state);
        map.put("code",code);
        return map;
    }
}
