package com.ddlottery.page;

import com.ddlottery.dao.DDbusinessMapper;
import com.ddlottery.dao.DDcouponMapper;
import com.ddlottery.model.DDbusiness;
import com.ddlottery.model.DDcoupon;
import com.ddlottery.model.DDorder;
import com.ddlottery.service.DDbusinessService;
import com.ddlottery.service.DDcouponService;
import com.ddlottery.tools.tools;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by ElNino on 16/2/1.
 */
@Controller
@RequestMapping("/")
public class couponPage {
    @Autowired
    DDbusinessMapper DDbusinessMapper;

    @Autowired
    DDbusinessService DDbusinessService;

    @Autowired
    DDcouponMapper DDcouponMapper;

    @Autowired
    DDcouponService DDcouponService;

    @RequestMapping("coupon_list")
    public ModelAndView coupon_list(Integer page,ModelAndView modelAndView){
        if(page == null){
            page = 1;
        }
        Map couponListMap = DDcouponService.couponList(page);
        modelAndView.addObject("couponList",couponListMap.get("list"));
        modelAndView.addObject("count",couponListMap.get("count"));
        modelAndView.addObject("page",couponListMap.get("page"));
        return modelAndView;
    }

    @RequestMapping("coupon_info_list")
    public ModelAndView coupon_info_list(Integer cid,Integer page,ModelAndView modelAndView){
        if(page == null){
            page = 1;
        }
        Map couponinfListMap = DDcouponService.couponByCid(cid, page);
        modelAndView.addObject("couponInfoList",couponinfListMap.get("list"));
        modelAndView.addObject("count",couponinfListMap.get("count"));
        modelAndView.addObject("page",couponinfListMap.get("page"));
        modelAndView.addObject("cid",cid);
        return modelAndView;
    }

    @RequestMapping("coupon_info")
    public ModelAndView coupon_add(DDcoupon coupon,
                                   String act,
                                   Integer cid,
                                   String page_starttime,
                                   String page_endtime,
                                   ModelAndView modelAndView) throws ParseException, UnsupportedEncodingException {
        DDbusiness business = new DDbusiness();
        Map businessMap = DDbusinessService.business_list(business,1);
        modelAndView.addObject("business",businessMap.get("list"));
        if(act == null) {
            modelAndView.addObject("type","add");
            return modelAndView;
        }
        if(act.equals("info")){
            modelAndView.addObject("type","edit");
            coupon = DDcouponMapper.selectByPrimaryKey(cid);
            modelAndView.addObject("info",coupon);
            return modelAndView;
        }
        Date starttime = tools.stringToDate(page_starttime);
        coupon.setStarttime(starttime);
        Date et =  tools.stringToDate(page_endtime);
        et.setTime(et.getTime()+1000 * 60 * 60 * 24-1);
        coupon.setEndtime(et);
        coupon.setCreattime(new Date());
        coupon.setTitle(new String(coupon.getTitle().getBytes("ISO-8859-1"), "utf-8"));
        if(coupon.getTips() != null) {
            coupon.setTips(new String(coupon.getTips().getBytes("ISO-8859-1"), "utf-8"));
        }
        if(coupon.getTypes() !=1) {
            if (coupon.getFullmuch() > 0 && coupon.getTypes() == 2) {
                coupon.setTypes((byte) 3);
            }
        }
        if(act.equals("add")) {
            DDcouponService.addCoupon(coupon);
            modelAndView.addObject("isok","ok");
            modelAndView.setViewName("redirect:coupon_list");
        }
        if(act.equals("edit")){
            DDcouponMapper.updateByPrimaryKeySelective(coupon);
            modelAndView.addObject("isok","ok");
            modelAndView.setViewName("redirect:coupon_list");
        }

        return modelAndView;
    }

}
