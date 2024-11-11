package com.nrifintech.bms.model;

import java.sql.Date;

public class QueryDetails {
	
	private String report_type;
	private Date from_date;
	private Date to_date;
	
	public QueryDetails() {
	}
	
	public QueryDetails(String report_type, Date from_date, Date to_date) {
		super();
		this.report_type = report_type;
		this.from_date = from_date;
		this.to_date = to_date;
	}
	
	public Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}
	public Date getTo_date() {
		return to_date;
	}
	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}
	public String getReport_type() {
		return report_type;
	}
	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}
	
	
	
	
	@Override
	public String toString() {
		return "QueryDates [from_date=" + from_date + ", to_date=" + to_date + "]";
	}
	
	
	
}
