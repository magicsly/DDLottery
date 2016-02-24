package com.ddlottery.page;

import com.ddlottery.dao.DDbusinessMapper;
import com.ddlottery.model.DDbusiness;
import com.ddlottery.service.DDbusinessService;
import com.ddlottery.tools.uploadFiles;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by ElNino on 16/2/1.
 */
@Controller
@RequestMapping("/")
public class businessPage {
    @Autowired
    DDbusinessService DDbusinessService;

    @Autowired
    DDbusinessMapper DDbusinessMapper;

    @RequestMapping("business_order")
    public ModelAndView md5(String bid,ModelAndView modelAndView){
        String codes = DigestUtils.md5Hex(bid + DDbusinessService.md5key);
        modelAndView.addObject("md5", codes);
        return modelAndView;
    }

    @RequestMapping("business_list")
    public ModelAndView business_list(Integer page,ModelAndView modelAndView){
        if(page == null){
            page = 1;
        }
        if(page < 1){
            page = 1;
        }
        Map businessListMap = DDbusinessService.business_list(page);
        modelAndView.addObject("businessList",businessListMap.get("list"));
        modelAndView.addObject("count",businessListMap.get("count"));
        modelAndView.addObject("page",businessListMap.get("page"));
        return modelAndView;
    }

    @RequestMapping("business_info")
    public ModelAndView business_info(
            String act,
            DDbusiness business,
            Integer bid,
            ModelAndView modelAndView
    ) throws UnsupportedEncodingException {
        if(act == null) {
            modelAndView.addObject("type","add");
            return modelAndView;
        }
        if(act.equals("info")){
            modelAndView.addObject("type","edit");
            business = DDbusinessMapper.selectByPrimaryKey(bid);
            modelAndView.addObject("info",business);
            return modelAndView;
        }
        business.setLocname(new String(business.getLocname().getBytes("ISO-8859-1"),"utf-8"));
        business.setAddress(new String(business.getAddress().getBytes("ISO-8859-1"), "utf-8"));
        business.setSalelot(new String(business.getSalelot().getBytes("ISO-8859-1"), "utf-8"));
        business.setSaletime(new String(business.getSaletime().getBytes("ISO-8859-1"), "utf-8"));
        business.setRealname(new String(business.getRealname().getBytes("ISO-8859-1"),"utf-8"));
        if(act.equals("add")){
            business.setBid(null);
            DDbusinessService.addBusiness(business);
            modelAndView.addObject("isok","ok");
            modelAndView.setViewName("redirect:business_list");
        }
        if(act.equals("edit")){
            if(!business.getPwd().equals("")){
                String md5pw = DigestUtils.md5Hex(business.getPwd());
                business.setPwd(md5pw);
            }else {
                business.setPwd("");
            }
            DDbusinessMapper.updateByPrimaryKeySelective(business);
            modelAndView.addObject("isok","ok");
            modelAndView.setViewName("redirect:business_list");
        }
        return modelAndView;
    }
}
