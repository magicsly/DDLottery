package com.whatever.test;

import java.util.UUID;

import com.whatever.lottery.jczq.Bet;
import com.whatever.lottery.jczq.Play;
import com.whatever.omr.OmrArea;
import com.whatever.omr.OmrText;
import com.whatever.slip.SlipJCZQ;

public class Test {
	public static void main_omr(String[] args) {
		
		OmrArea oa = new OmrArea(13, 36, 0, 0);
		
		OmrArea oaHead = new OmrArea(12,2,1,0);
		oaHead.mark(0, 0);
		oaHead.mark(1, 1);
		oaHead.mark(2, 0);
		oaHead.mark(3, 1);
		oaHead.mark(4, 0);
		oaHead.mark(6, 0);
		oaHead.mark(7, 0);
		oaHead.mark(8, 0);
		//oaHead.mark(12, 0);
		
		oa.fill(oaHead);
		
		OmrArea oaPassType = new OmrArea(13,1,1,2);
		//oaPassType.mark(3, 0);
		oaPassType.mark(5, 0);
		//oaPassType.mark(8, 0);
		
		oa.fill(oaPassType);
		
		OmrArea oaMatch1 = new OmrArea(4,9,1,3);
		oaMatch1.mark(2, 2);
		oaMatch1.mark(0, 3);
		oaMatch1.mark(0, 7);
		
		oa.fill(oaMatch1);
		
		OmrArea oaMatch2 = new OmrArea(4,9,5,3);
		oaMatch2.mark(2, 2);
		oaMatch2.mark(1, 3);
		oaMatch2.mark(0, 7);
		
		oa.fill(oaMatch2);
		
		OmrArea oaMatch3 = new OmrArea(4,9,9,3);
		oaMatch3.mark(2, 2);
		oaMatch3.mark(0, 3);
		oaMatch3.mark(1, 3);
		oaMatch3.mark(0, 7);
		
		oa.fill(oaMatch3);
		
		OmrArea oaMatch4 = new OmrArea(4,9,1,12);
		oaMatch4.mark(2, 2);
		oaMatch4.mark(2, 3);
		oaMatch4.mark(0, 7);
		
		oa.fill(oaMatch4);
		
		OmrArea oaMatch5 = new OmrArea(4,9,5,12);
		oaMatch5.mark(2, 2);
		oaMatch5.mark(3, 3);
		oaMatch5.mark(0, 7);
		
		oa.fill(oaMatch5);
		
		OmrArea oaMatch6 = new OmrArea(4,9,9,12);
		oaMatch6.mark(2, 2);
		oaMatch6.mark(0, 3);
		oaMatch6.mark(3, 3);
		oaMatch6.mark(0, 7);
		
		oa.fill(oaMatch6);
		
		OmrArea oaMatch7 = new OmrArea(4,9,1,21);
		oaMatch7.mark(2, 2);
		oaMatch7.mark(1, 3);
		oaMatch7.mark(3, 3);
		oaMatch7.mark(0, 7);
		
		oa.fill(oaMatch7);
		
		OmrArea oaMatch8 = new OmrArea(4,9,5,21);
		oaMatch8.mark(2, 2);
		oaMatch8.mark(0, 3);
		oaMatch8.mark(1, 3);
		oaMatch8.mark(3, 3);
		oaMatch8.mark(0, 7);
		
		oa.fill(oaMatch8);
		
		OmrArea oaPass = new OmrArea(8,3,1,30);
		oaPass.mark(0, 2);
		
		oa.fill(oaPass);
		
		OmrArea oaMulti = new OmrArea(4,5,9,30);
		oaMulti.mark(1, 4);
		oaMulti.mark(0, 4);
		oaMulti.mark(0, 3);
		
		oa.fill(oaMulti);
		
		
		
		
		//System.out.println(oa.toString());
	}
	
	public static void main(String[] args) throws Exception {
		//System.out.println(SlipJCZQ.parse("99|HH|JQS>010101003=1,JQS>010101003=1|2*1"));
		//Bet bet = new Bet("99|HH|RQSPF>151212001=3/1/0,JQS>151212002=1/0/7|2*1");
		
		//Bet bet = new Bet("1|HH|RQSPF>151212001=3/1/0,SPF>151212002=1/0/3,RQSPF>151212003=3/1/0,JQS>151212004=3/0,SPF>151212005=3/0,RQSPF>151212006=3/1/0,|6*1");
		Bet bet = new Bet("1|HH|RQSPF>151213001=3,SPF>151213002=1,RQSPF>151213003=0,SPF>151213004=3,RQSPF>151213005=1,SPF>151213006=0,RQSPF>151213007=3,RQSPF>151213008=1|8*1");
		//Bet bet = new Bet("1|SPF|151226001=3,151226002=1|2*1");
		
		String str = SlipJCZQ.parse(bet);
		OmrText t = new OmrText();
		
		t.appendH1Centerln("彩票投注单");
		t.appendCenterln("用户名:足球爱好者");
		t.appendCenterln("竞彩足球混合过关  8x1");
		t.appendCenterln(UUID.randomUUID().toString());
		
		t.appendLineln();
		t.appendHex(str);
		t.appendLineln();
		t.appendCenterln("投注单过期时间:2015-04-10 13:55:00");
		t.appendCenterln("购彩有风险 投注需谨慎");
		t.appendH1Centerln("请务必核对票面内容！");
		t.appendFeed();
		t.appendCut();
		
		
		System.out.println(t.toString());
		 
	}
	
}
