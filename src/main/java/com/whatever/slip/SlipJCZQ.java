package com.whatever.slip;

import com.whatever.lottery.jczq.Bet;
import com.whatever.lottery.jczq.Pass;

public class SlipJCZQ {
	
	public static String parse(Bet bet) throws Exception{
		Pass pass = Pass.valueOf("PASS"+bet.getPass().replace('*', '_'));
		ISlipJCZQ slip;
		if (pass.ordinal() <= Pass.PASS3_4.ordinal()){
			slip = new SlipJCZQ3();
		} else if (pass.ordinal() <= Pass.PASS6_57.ordinal()){
			slip = new SlipJCZQ6();
		} else {
			slip = new SlipJCZQ8();
		}
		
		return slip.draw(bet);
	}
}
