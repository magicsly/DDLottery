package com.ddlottery.model;

import java.util.Date;

public class DDbusiness {
    private Integer bid;

    private String pwd;

    private String locname;

    private String address;

    private Float cox;

    private Float coy;

    private String bname;

    private String realname;

    private String idcard;

    private String mobile;

    private String bank;

    private String bankname;

    private String bankcode;

    private String saletime;

    private Byte type;

    private String cardimg;

    private String saleimg;

    private String businessimg;

    private String salecard;

    private Float money;

    private Date creattime;

    private Date logintime;

    private String ip;

    private Byte state;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname == null ? null : locname.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Float getCox() {
        return cox;
    }

    public void setCox(Float cox) {
        this.cox = cox;
    }

    public Float getCoy() {
        return coy;
    }

    public void setCoy(Float coy) {
        this.coy = coy;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getSaletime() {
        return saletime;
    }

    public void setSaletime(String saletime) {
        this.saletime = saletime == null ? null : saletime.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getCardimg() {
        return cardimg;
    }

    public void setCardimg(String cardimg) {
        this.cardimg = cardimg == null ? null : cardimg.trim();
    }

    public String getSaleimg() {
        return saleimg;
    }

    public void setSaleimg(String saleimg) {
        this.saleimg = saleimg == null ? null : saleimg.trim();
    }

    public String getBusinessimg() {
        return businessimg;
    }

    public void setBusinessimg(String businessimg) {
        this.businessimg = businessimg == null ? null : businessimg.trim();
    }

    public String getSalecard() {
        return salecard;
    }

    public void setSalecard(String salecard) {
        this.salecard = salecard == null ? null : salecard.trim();
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}