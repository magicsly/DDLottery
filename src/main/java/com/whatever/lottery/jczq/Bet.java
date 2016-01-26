package com.whatever.lottery.jczq;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;

public class Bet {
	int money = 2;
	int beishu;
	String play;
	String pass;
	List<Item> itemList = new ArrayList<Item>();
	
	
	public int getMoney() {
		return money;
	}

	public int getBeishu() {
		return beishu;
	}

	public String getPlay() {
		return play;
	}

	public String getPass() {
		return pass;
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public Bet(String input) throws Exception{
		int zhushu = 0;
		String itemStr;
		int itemCount = 0;
		List<String> subPlayList = new ArrayList<String>();
		List<String> numberList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Calendar cal = Calendar.getInstance();
		
		//格式判断
		Matcher matcher = Constants.PATTERN.matcher(input.replaceAll(":|-", "_").toUpperCase());
		if (matcher.find()) {
			beishu = Integer.parseInt(matcher.group(1));
			play = matcher.group(2);
			itemStr = matcher.group(3);
			itemCount = Integer.parseInt(matcher.group(4));
			zhushu = Integer.parseInt(matcher.group(5));
		}else{
			throw new Exception("格式不正确!");
		}
		
		//倍数判断
		if (beishu<Constants.MIN_MULTI || beishu>Constants.MAX_MULTI){
			throw new Exception("倍数必须介于"+Constants.MIN_MULTI+"与"+Constants.MAX_MULTI+"之间!");
		}
		
		//投注串处理
		String[] arrItem = itemStr.split(",");
		if (arrItem.length != itemCount){
			throw new Exception("投注场次数量不正确!");
		}
		
		for (String str: arrItem){
			Item item = new Item();
			int selectCount = 0;
			
			String subPlay = play;
			String number;
			
			String[] arr = str.split("=");
			if (arr.length != 2){
				throw new Exception("场次格式不正确!");
			}
			
			if (play.equals("HH")){
				String[] arrLeft = arr[0].split(">");
				if (arrLeft.length != 2){
					throw new Exception("混合玩法格式不正确!");
				}
				subPlay = arrLeft[0];
				number = arrLeft[1];
			}else{
				number = arr[0];
			}

			try{
				if (!number.matches("\\d{9}")){
					throw new Exception("场次编号格式不正确!");
				}
				cal.setTime(sdf.parse(number.substring(0,6)));
				//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
				item.setSerial(number);
				item.setDow(cal.get(Calendar.DAY_OF_WEEK));
				item.setNum(number.substring(7));
			}catch(Exception e){
				throw new Exception("场次编号格式不正确!");
			}
			
			if (numberList.contains(number)){
				throw new Exception("场次重复!");
			}else{
				numberList.add(number);
			}
			
			String[] arrRight = arr[1].split("/");
			selectCount = arrRight.length;
			
			try{
				Play.valueOf(subPlay); 
			}catch(Exception e){
				throw new Exception("玩法不正确!");
			}
			
			item.setPlay(subPlay);
			
			try{
				for (String s:arrRight){
					item.addSelect(Select.valueOf(subPlay+s));
				}
			}catch(Exception e){
				throw new Exception("选项不正确!");
			}
			
			subPlayList.add(subPlay);
			
			if (selectCount != item.getSelects().size()) {
				throw new Exception("选项重复!");
			}
			
			itemList.add(item);
			
		}
		
		//串关判断
		Pass passEnum;
		try{
			passEnum = Pass.valueOf("PASS"+itemCount+"_"+zhushu);
			pass = itemCount+"*"+zhushu;
		}catch(Exception e){
			throw new Exception("串关选项不正确!");
		}
		
		if (play.equals("HH")){
			if (subPlayList.contains("CBF")||subPlayList.contains("BQC")){
				if (passEnum.ordinal()<1 || passEnum.ordinal()>4){
					throw new Exception("串关选项不支持!");
				}
			}else if (subPlayList.contains("JQS")){
				if (passEnum.ordinal()<1 || passEnum.ordinal()>26){
					throw new Exception("串关选项不支持!");
				}
			}
		} else if (play.equals("SPF")){
			
		} else if (play.equals("RQSPF")){
			
		} else if (play.equals("JQS")){
			if (passEnum.ordinal()<1 || passEnum.ordinal()>26){
				throw new Exception("串关选项不支持!");
			}
		} else if (play.equals("CBF")){
			if (passEnum.ordinal()>4){
				throw new Exception("串关选项不支持!");
			}
		} else if (play.equals("BQC")){
			if (passEnum.ordinal()>4){
				throw new Exception("串关选项不支持!");
			}
		} 
		
		//总金额计算
		money *= zhushu;
		
		for (Item item:itemList){
			money *= item.getSelectCount();
		}
		
		money *= beishu;
		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(beishu).append("|");
		sb.append(play).append("|");
		for (Item item:itemList){
			if (play.equals("HH")){
				sb.append(item.getPlay()).append(">");
			}
			
			sb.append(item.getSerial()).append("=");
			for (Select select:item.getSelects()){
				String s = select.toString().replaceAll("[A-Z]{0,5}", "");
				if (play.equals("CBF")){
					s.replace('_', ':');
				}else{
					s.replace('_', '-');
				}
				sb.append(s).append('/');
			}
			sb.setLength(sb.length()-1);
			sb.append(',');
		}
		sb.setLength(sb.length()-1);
		sb.append("|");
		
		sb.append(pass);
		
		
		return sb.toString();
	}
}
