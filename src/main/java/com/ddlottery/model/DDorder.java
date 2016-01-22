package com.ddlottery.model;

import java.util.Date;

public class DDorder {
    private Integer oid;

    private Integer uid;

    private Integer bid;

    private Integer lot;

    private Integer play;

    private String str;

    private Integer num;

    private Integer multiple;

    private Float money;

    private String content;

    private Byte isprint;

    private Byte iswin;

    private Float bonus;

    private Byte state;

    private Date creattime;

    private Date closetime;

    private Date printtime;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getLot() {
        return lot;
    }

    public void setLot(Integer lot) {
        this.lot = lot;
    }

    public Integer getPlay() {
        return play;
    }

    public void setPlay(Integer play) {
        this.play = play;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str == null ? null : str.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public void setMultiple(Integer multiple) {
        this.multiple = multiple;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Byte getIsprint() {
        return isprint;
    }

    public void setIsprint(Byte isprint) {
        this.isprint = isprint;
    }

    public Byte getIswin() {
        return iswin;
    }

    public void setIswin(Byte iswin) {
        this.iswin = iswin;
    }

    public Float getBonus() {
        return bonus;
    }

    public void setBonus(Float bonus) {
        this.bonus = bonus;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    public Date getClosetime() {
        return closetime;
    }

    public void setClosetime(Date closetime) {
        this.closetime = closetime;
    }

    public Date getPrinttime() {
        return printtime;
    }

    public void setPrinttime(Date printtime) {
        this.printtime = printtime;
    }
}