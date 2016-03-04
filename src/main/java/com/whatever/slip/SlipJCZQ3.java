package com.whatever.slip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import com.whatever.lottery.jczq.Bet;
import com.whatever.lottery.jczq.Item;
import com.whatever.lottery.jczq.Pass;
import com.whatever.lottery.jczq.Select;
import com.whatever.omr.OmrArea;
import com.whatever.omr.OmrPoint;

public class SlipJCZQ3 implements ISlipJCZQ {
	
	static final HashMap<Integer, OmrPoint> mapDow = new HashMap<Integer, OmrPoint>();
	static final TreeMap<Integer, OmrPoint> mapNum = new TreeMap<Integer, OmrPoint>(); 
	static final HashMap<Select, OmrPoint> mapSelect = new HashMap<Select, OmrPoint>();
	static final HashMap<Pass, OmrPoint> mapPass = new HashMap<Pass, OmrPoint>();
	static final TreeMap<Integer, OmrPoint> mapMulti = new TreeMap<Integer, OmrPoint>();
	
	static {
		mapDow.put(2,new OmrPoint(0,1));
		mapDow.put(3,new OmrPoint(1,1));
		mapDow.put(4,new OmrPoint(2,1));
		mapDow.put(5,new OmrPoint(3,1));
		
		mapDow.put(6,new OmrPoint(0,2));
		mapDow.put(7,new OmrPoint(1,2));
		mapDow.put(1,new OmrPoint(2,2));
		
		mapNum.put(1, new OmrPoint(0,3));
		mapNum.put(2, new OmrPoint(1,3));
		mapNum.put(4, new OmrPoint(2,3));
		mapNum.put(5, new OmrPoint(3,3));
		
		mapNum.put(10, new OmrPoint(0,4));
		mapNum.put(20, new OmrPoint(1,4));
		mapNum.put(40, new OmrPoint(2,4));
		mapNum.put(50, new OmrPoint(3,4));
		
		mapNum.put(100, new OmrPoint(0,5));
		mapNum.put(200, new OmrPoint(1,5));
		mapNum.put(400, new OmrPoint(2,5));
		mapNum.put(500, new OmrPoint(3,5));
		
		mapSelect.put(Select.SPF3, new OmrPoint(0,7));
		mapSelect.put(Select.SPF1, new OmrPoint(1,7));
		mapSelect.put(Select.SPF0, new OmrPoint(2,7));
		
		mapSelect.put(Select.RQSPF3, new OmrPoint(0,8));
		mapSelect.put(Select.RQSPF1, new OmrPoint(1,8));
		mapSelect.put(Select.RQSPF0, new OmrPoint(2,8));
		
		mapSelect.put(Select.CBF1_0, new OmrPoint(0,9));
		mapSelect.put(Select.CBF4_2, new OmrPoint(1,9));
		mapSelect.put(Select.CBF2_4, new OmrPoint(2,9));
		mapSelect.put(Select.CBF0_1, new OmrPoint(3,9));
		
		mapSelect.put(Select.CBF2_0, new OmrPoint(0,10));
		mapSelect.put(Select.CBF5_0, new OmrPoint(1,10));
		mapSelect.put(Select.CBF0_5, new OmrPoint(2,10));
		mapSelect.put(Select.CBF0_2, new OmrPoint(3,10));
		
		mapSelect.put(Select.CBF2_1, new OmrPoint(0,11));
		mapSelect.put(Select.CBF5_1, new OmrPoint(1,11));
		mapSelect.put(Select.CBF1_5, new OmrPoint(2,11));
		mapSelect.put(Select.CBF1_2, new OmrPoint(3,11));
		
		mapSelect.put(Select.CBF3_0, new OmrPoint(0,12));
		mapSelect.put(Select.CBF5_2, new OmrPoint(1,12));
		mapSelect.put(Select.CBF2_5, new OmrPoint(2,12));
		mapSelect.put(Select.CBF0_3, new OmrPoint(3,12));
		
		mapSelect.put(Select.CBF3_1, new OmrPoint(0,13));
		mapSelect.put(Select.CBF9_0, new OmrPoint(1,13));
		mapSelect.put(Select.CBF0_9, new OmrPoint(2,13));
		mapSelect.put(Select.CBF1_3, new OmrPoint(3,13));
		
		mapSelect.put(Select.CBF3_2, new OmrPoint(0,14));
		mapSelect.put(Select.CBF0_0, new OmrPoint(1,14));
		mapSelect.put(Select.CBF0_3, new OmrPoint(2,14));
		mapSelect.put(Select.CBF2_3, new OmrPoint(3,14));
		
		mapSelect.put(Select.CBF4_0, new OmrPoint(0,15));
		mapSelect.put(Select.CBF1_1, new OmrPoint(1,15));
		mapSelect.put(Select.CBF9_9, new OmrPoint(2,15));
		mapSelect.put(Select.CBF0_4, new OmrPoint(3,15));
		
		mapSelect.put(Select.CBF4_1, new OmrPoint(0,16));
		mapSelect.put(Select.CBF2_2, new OmrPoint(1,16));
		mapSelect.put(Select.CBF1_4, new OmrPoint(3,16));
		
		mapSelect.put(Select.BQC3_3, new OmrPoint(0,17));
		mapSelect.put(Select.BQC3_1, new OmrPoint(1,17));
		mapSelect.put(Select.BQC3_0, new OmrPoint(2,17));
		
		mapSelect.put(Select.BQC1_3, new OmrPoint(0,18));
		mapSelect.put(Select.BQC1_1, new OmrPoint(1,18));
		mapSelect.put(Select.BQC1_0, new OmrPoint(2,18));
		
		mapSelect.put(Select.BQC0_3, new OmrPoint(0,19));
		mapSelect.put(Select.BQC0_1, new OmrPoint(1,19));
		mapSelect.put(Select.BQC0_0, new OmrPoint(2,19));
		
		mapSelect.put(Select.JQS0, new OmrPoint(0,20));
		mapSelect.put(Select.JQS1, new OmrPoint(1,20));
		mapSelect.put(Select.JQS2, new OmrPoint(2,20));
		mapSelect.put(Select.JQS3, new OmrPoint(3,20));
		
		mapSelect.put(Select.JQS4, new OmrPoint(0,21));
		mapSelect.put(Select.JQS5, new OmrPoint(1,21));
		mapSelect.put(Select.JQS6, new OmrPoint(2,21));
		mapSelect.put(Select.JQS7, new OmrPoint(3,21));
		
		mapPass.put(Pass.PASS2_1, new OmrPoint(0,1));
		mapPass.put(Pass.PASS3_1, new OmrPoint(1,1));
		mapPass.put(Pass.PASS3_3, new OmrPoint(2,1));
		mapPass.put(Pass.PASS3_4, new OmrPoint(3,1));
		
		mapMulti.put(1, new OmrPoint(0,1));
		mapMulti.put(2, new OmrPoint(1,1));
		mapMulti.put(3, new OmrPoint(2,1));
		mapMulti.put(4, new OmrPoint(3,1));
		
		mapMulti.put(5, new OmrPoint(0,2));
		mapMulti.put(6, new OmrPoint(1,2));
		mapMulti.put(7, new OmrPoint(2,2));
		mapMulti.put(8, new OmrPoint(3,2));
		
		mapMulti.put(9, new OmrPoint(0,3));
		mapMulti.put(10, new OmrPoint(1,3));
		mapMulti.put(20, new OmrPoint(2,3));
		mapMulti.put(30, new OmrPoint(3,3));
		
		mapMulti.put(40, new OmrPoint(0, 4));
		mapMulti.put(50, new OmrPoint(1, 4));
		
	}
	
	OmrArea oaAll;
	OmrArea oaHead;
	OmrArea oaPassType;
	OmrArea oaPassMode;
	OmrArea oaMulti;
	List<OmrArea> oaMatchList = new ArrayList<OmrArea>();
	
	public SlipJCZQ3() {
		oaAll = new OmrArea(13, 31, 0, 0);
		
		oaHead = new OmrArea(12, 2, 1, 0);
		oaHead.mark(0, 0);
		oaHead.mark(2, 0);
		oaHead.mark(3, 1);
		oaHead.mark(4, 0);
		oaHead.mark(6, 0);
		oaHead.mark(8, 0);
		oaHead.mark(9, 0);
		oaHead.mark(10, 0);
		oaHead.mark(11, 0);
		
		oaPassType = new OmrArea(12,1,1,2);

		oaMatchList.add(new OmrArea(4,22,1,3));
		oaMatchList.add(new OmrArea(4,22,5,3));
		oaMatchList.add(new OmrArea(4,22,9,3));
		
		oaPassMode = new OmrArea(8,5,1,25);
		oaMulti = new OmrArea(4,5,9,25);
	}
	
	@Override
	public String draw(Bet bet) throws Exception {
		oaAll.fill(oaHead);
		
		markPassType(oaPassType, bet);
		oaAll.fill(oaPassType);
		
		for (int i=0;i<bet.getItemList().size();i++){
			Item item = bet.getItemList().get(i);
			if (item != null){
				OmrArea oaMatch = oaMatchList.get(i);
				markMatch(oaMatch, item);
				oaAll.fill(oaMatch);
			}
		}
		
		markPassMode(oaPassMode, bet);
		oaAll.fill(oaPassMode);
		
		markMulti(oaMulti, bet);
		oaAll.fill(oaMulti);
		
		return oaAll.toString();
	}
	
	private void markPassType(OmrArea oa, Bet bet){
		if (bet.getPlay().equals("HH")){
			oa.mark(8, 0);
		}else if (Pass.valueOf("PASS"+bet.getPass().replace('*', '_')).equals(Pass.PASS1_1)){
			oa.mark(3, 0);
		}else {
			oa.mark(5, 0);
		}
	}
	
	private void markPassMode(OmrArea oa, Bet bet){
		Pass pass = Pass.valueOf("PASS"+bet.getPass().replace('*', '_'));
		if (pass != Pass.PASS1_1) {
			oa.mark(mapPass.get(pass));
		}
	}
	
	private void markMatch(OmrArea oa, Item item) throws Exception{
		oa.mark(mapDow.get(item.getDow()));
		
		int num = Integer.valueOf(item.getNum());
		int i = 0;
		Set<Integer> numSet = mapNum.descendingKeySet();
		Iterator<Integer> iter = numSet.iterator();
		while (iter.hasNext()) {
			Integer key = iter.next();
			if (key+i <= num){
				oa.mark(mapNum.get(key));
				i+=key;
			}
			
			if (i==num){
				break;
			}
		}
		
		if (i != num){
			throw new Exception("无法填写场次");
		}
		
		for (Select select :item.getSelects()){
			oa.mark(mapSelect.get(select));
		}
	}
	
	private void markMulti(OmrArea oa, Bet bet) throws Exception{
		
		int beishu = bet.getBeishu();
		int i = 0;
		Set<Integer> multiSet = mapMulti.descendingKeySet();
		Iterator<Integer> iter = multiSet.iterator();
		while (iter.hasNext()) {
			Integer key = iter.next();
			if (key+i <= beishu){
				oa.mark(mapMulti.get(key));
				i+=key;
			}
			
			if (i==beishu){
				break;
			}
		}
		
		if (i != beishu){
			throw new Exception("无法填写倍数");
		}
		
	}
}
