package com.ddlottery.model;

import java.util.Date;

public class DDcoupon {
    private Integer cid;

    private String title;

    private Byte types;

    private Float money;

    private Integer num;

    private Integer restnum;

    private Integer usenum;

    private String bid;

    private String bname;

    private Float fullmuch;

    private Date starttime;

    private Date endtime;

    private Integer limitnum;

    private String tips;

    private Date creattime;

    private Byte states;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getTypes() {
        return types;
    }

    public void setTypes(Byte types) {
        this.types = types;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getRestnum() {
        return restnum;
    }

    public void setRestnum(Integer restnum) {
        this.restnum = restnum;
    }

    public Integer getUsenum() {
        return usenum;
    }

    public void setUsenum(Integer usenum) {
        this.usenum = usenum;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public Float getFullmuch() {
        return fullmuch;
    }

    public void setFullmuch(Float fullmuch) {
        this.fullmuch = fullmuch;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getLimitnum() {
        return limitnum;
    }

    public void setLimitnum(Integer limitnum) {
        this.limitnum = limitnum;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Byte getStates() {
        return states;
    }

    public void setStates(Byte states) {
        this.states = states;
    }
}