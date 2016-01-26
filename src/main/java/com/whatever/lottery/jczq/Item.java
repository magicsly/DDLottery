package com.whatever.lottery.jczq;

import java.util.HashSet;

public class Item {
	String serial;
	int dow;
	String num;
	String play;
	HashSet<Select> selects = new HashSet<Select>();
	int selectCount;
	
	public String getSerial() {
		return serial;
	}
	
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public int getDow() {
		return dow;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public void setDow(int dow) {
		this.dow = dow;
	}
	
	public String getPlay() {
		return play;
	}
	
	public void setPlay(String play) {
		this.play = play;
	}
	
	public HashSet<Select> getSelects() {
		return selects;
	}
	
	public int getSelectCount() {
		return selectCount;
	}
	
	public void addSelect(Select select) {
		this.selects.add(select);
		selectCount++;
	}
}
