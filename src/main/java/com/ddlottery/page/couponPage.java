package com.ddlottery.page;

import com.ddlottery.dao.DDbusinessMapper;
import com.ddlottery.dao.DDcouponMapper;
import com.ddlottery.model.DDbusiness;
import com.ddlottery.model.DDcoupon;
import com.ddlottery.model.DDorder;
import com.ddlottery.service.DDbusinessService;
import com.ddlottery.tools.tools;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ElNino on 16/2/1.
 */
@Controller
@RequestMapping("/")
public class couponPage {
    @Autowired
    DDbusinessMapper DDbusinessMapper;

    @Autowired
    DDcouponMapper DDcouponMapper;


    @RequestMapping("coupon_add")
    public ModelAndView coupon_add(DDcoupon coupon,
                                   String act,
                                   String page_starttime,
                                   String page_endtime,
                                   ModelAndView modelAndView) throws ParseException {
        if(act == null) {
            PageBounds pageBounds = new PageBounds(10,1);
            ArrayList<DDbusiness> businessList = DDbusinessMapper.selectBusiness(pageBounds);
            modelAndView.addObject("isok","no");
            modelAndView.addObject("businessList",businessList);
        }else{
            Date starttime = tools.stringToDate(page_starttime);
            Date endtime =  tools.stringToDate(page_endtime);
            coupon.setStarttime(starttime);
            coupon.setEndtime(endtime);
            coupon.setCreattime(new Date());
            if(act.equals("add")) {
                DDcouponMapper.insertSelective(coupon);
                modelAndView.addObject("isok","ok");
                modelAndView.setViewName("redirect:coupon_add");
            }
        }
        return modelAndView;
    }

}
