package com.whatever.lottery.jczq;

import java.util.regex.Pattern;

public class Constants {
	public static final int MAX_MULTI = 99;
	public static final int MIN_MULTI = 1;
	public static final Pattern PATTERN = Pattern.compile("(\\d+)\\|(SPF|RQSPF|JQS|CBF|BQC|HH)\\|(.*?)\\|(\\d)\\*(\\d+)");
}
