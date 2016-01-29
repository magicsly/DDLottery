package com.ddlottery.controller;

import com.ddlottery.model.DDbusiness;
import com.ddlottery.service.DDbusinessService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ElNino on 16/1/22.
 */
@Controller
@RequestMapping("/")
public class businessController {
    @Autowired
    DDbusinessService DDbusinessService;

    /**
     *
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/addbusiness")
    @ResponseBody
    public Map addbusiness(@RequestParam(value="locname",defaultValue = "",required=false) String locname,
                           @RequestParam(value="pwd",defaultValue = "",required=false) String pwd,
                           @RequestParam(value="bimage",defaultValue = "",required=false) String bimage,
                           @RequestParam(value="address",defaultValue = "",required=false) String address,
                           @RequestParam(value="cox",defaultValue = "0",required=false) Float cox,
                           @RequestParam(value="coy",defaultValue = "0",required=false) Float coy,
                           @RequestParam(value="bname",defaultValue = "",required=false) String bname,
                           @RequestParam(value="realname",defaultValue = "",required=false) String realname,
                           @RequestParam(value="idcard",defaultValue = "",required=false) String idcard,
                           @RequestParam(value="mobile",defaultValue = "",required=false) String mobile,
                           @RequestParam(value="bank",defaultValue = "",required=false) String bank,
                           @RequestParam(value="bankname",defaultValue = "",required=false) String bankname,
                           @RequestParam(value="bankcode",defaultValue = "",required=false) String bankcode,
                           @RequestParam(value="saletime",defaultValue = "",required=false) String saletime,
                           @RequestParam(value="type",defaultValue = "0",required=false) byte type
    ) throws UnsupportedEncodingException {
        DDbusiness business = new DDbusiness();
        business.setLocname(new String(locname.getBytes("ISO-8859-1"),"utf-8"));
        business.setPwd(pwd);
        business.setAddress(address);
        business.setCox(cox);
        business.setCoy(coy);
        business.setBname(bname);
        business.setRealname(realname);
        business.setIdcard(idcard);
        business.setMobile(mobile);
        business.setBank(bank);
        business.setBankname(bankname);
        business.setBankcode(bankcode);
        business.setSaletime(saletime);
        business.setType(type);
        Integer code = DDbusinessService.addBusiness(business);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",code);
        return map;
    }

    @RequestMapping(value = "/machlogin")
    @ResponseBody
    public Map machlogin(@RequestParam(value="mobile",defaultValue = "",required=false) String mobile,
                         @RequestParam(value="key",defaultValue = "",required=false) String key
    ){
        Integer code = DDbusinessService.machLogin(mobile,key);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("code",code);
        return map;
    }

    @RequestMapping(value = "/nearbusiness")
    @ResponseBody
    public Map nearbusiness(@RequestParam(value="cox",defaultValue = "0",required=false) Float cox,
                            @RequestParam(value="coy",defaultValue = "0",required=false) Float coy,
                            @RequestParam(value="page",defaultValue = "1",required=false) Integer page
    ){
        Map<String,Object> map = new HashMap<String, Object>();
        map = DDbusinessService.nearBusiness(cox,coy,page);
        return map;
    }

    @RequestMapping(value = "/businessList")
    @ResponseBody
    public Map business_List(@RequestParam(value="page",defaultValue = "1",required=false) Integer page
    ){
        Map<String,Object> map = DDbusinessService.business_list(page);
        return map;
    }

    @RequestMapping("business_order")
    public ModelAndView md5(String bid,ModelAndView modelAndView){
        String codes = DigestUtils.md5Hex(bid + DDbusinessService.md5key);
        modelAndView.addObject("md5", codes);
        return modelAndView;
    }

    @RequestMapping("test")
    public ModelAndView test(String mobile,ModelAndView modelAndView){
        System.out.println(mobile);
        modelAndView.addObject("mobile",mobile);
        return modelAndView;
    }


}
