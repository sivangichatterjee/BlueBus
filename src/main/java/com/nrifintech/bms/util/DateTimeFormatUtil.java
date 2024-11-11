package com.nrifintech.bms.util;

import java.text.SimpleDateFormat;

import org.springframework.format.annotation.DateTimeFormat;

public class DateTimeFormatUtil {
	private static SimpleDateFormat DateFormatddMMMyyyy = new SimpleDateFormat("dd MMM yyyy");
	private static SimpleDateFormat DateFormatyyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat TimeFormatHHmm = new SimpleDateFormat("HH:mm");
	
	public static SimpleDateFormat getDateFormatddMMMyyyy() {
		return DateFormatddMMMyyyy;
	}
	public static void setDateFormatddMMMyyyy(SimpleDateFormat dateFormatddMMMyyyy) {
		DateFormatddMMMyyyy = dateFormatddMMMyyyy;
	}
	public static SimpleDateFormat getDateFormatyyyyMMdd() {
		return DateFormatyyyyMMdd;
	}
	public static void setDateFormatyyyyMMdd(SimpleDateFormat dateFormatyyyyMMdd) {
		DateFormatyyyyMMdd = dateFormatyyyyMMdd;
	}
	public static SimpleDateFormat getTimeFormatHHmm() {
		return TimeFormatHHmm;
	}
	public static void setTimeFormatHHmm(SimpleDateFormat timeFormatHHmm) {
		TimeFormatHHmm = timeFormatHHmm;
	}
	
	
}
