package com.whatever.omr;

import java.io.UnsupportedEncodingException;

public class OmrText {
	private final static char[] mChars = "0123456789ABCDEF".toCharArray(); 
	StringBuilder sb = new StringBuilder();
	
	public OmrText appendH1Centerln(String text){
		reset();
		sb.append("1B2101");//9 font
		sb.append("1D2110");//double size
		sb.append("1B2000");//default char spacing
		sb.append("1B3322");//line space 22 in hex
		sb.append("1B6101");//center
		hexAppend(text);
		sb.append("0A");
		return this;
	}
	
	public OmrText appendCenterln(String text){
		reset();
		sb.append("1B2100");//default font
		sb.append("1D2100");//default font scale
		sb.append("1B2000");//default char spacing
		sb.append("1B331A");//line space 1A in hex
		sb.append("1B6101");//align center
		hexAppend(text);
		sb.append("0A");
		return this;
	}
	
	public OmrText appendLeftln(String text){
		reset();
		hexAppend(text);
		sb.append("0A");
		return this;
	}
	
	public OmrText appendFeed(){
		reset();
		sb.append("1B6405");
		return this;
	}
	
	public OmrText appendCut(){
		reset();
		sb.append("1D564200");
		return this;
	}
	
	public OmrText appendLineln(){
		reset();
		sb.append("1B6101");
		sb.append("A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A4A9A40A");
		return this;
	}
	
	public OmrText append(String text){
		reset();
		hexAppend(text);
		return this;
	}
	
	public OmrText appendHex(String text){
		reset();
		sb.append(text);
		return this;
	}
	
	private void reset(){
		sb.append("1B2500");//cancel user defined font
		sb.append("1B2100");//reset default font
		sb.append("1D2100");//reset default font scale
		sb.append("1B2000");//reset default char spacing
		sb.append("1B331A");//reset line space 1A in hex
		sb.append("1B6100");//reset align left
	}
	
	private void hexAppend(String text){
		try {
			byte[] bs = text.getBytes("GBK");
			for (int i = 0; i < bs.length; i++){    
	            sb.append(mChars[(bs[i] & 0xFF) >> 4]);    
	            sb.append(mChars[bs[i] & 0x0F]);  
	        }    
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}    
	}
	
	public String toString(){
		return sb.toString();
	}
}
