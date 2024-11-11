package com.nrifintech.bms.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import com.nrifintech.bms.util.DateTimeFormatUtil;

public class PaymentRequestModel {
	// Send from Search Page to Payment Controller
	private String busCode;
	
	private String startStopName;
	
	private String endStopName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfDept;
	
	private Date startTime;
	private Date endTime;
	
	Logger logger = LoggerFactory.getLogger(PaymentRequestModel.class);
	
	public PaymentRequestModel(){
		
	}
	
	@Override
	public String toString() {
		return String.format("BusCode: %s \nStartStopName: %s \nEndStopName: %s \nDateOfDept: %s \nStartTime: %s \nEndTime: %s", busCode, startStopName, endStopName, dateOfDept, startTime, endTime);
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getStartStopName() {
		return startStopName;
	}

	public void setStartStopName(String startStopName) {
		this.startStopName = startStopName;
	}

	public String getEndStopName() {
		return endStopName;
	}

	public void setEndStopName(String endStopName) {
		this.endStopName = endStopName;
	}

	public Date getDateOfDept() {
		return dateOfDept;
	}

	public void setDateOfDept(Date dateOfDept) {
		this.dateOfDept = dateOfDept;
	}
	
	public void setDateOfDept(String dateOfDept) {
		try {
			Date date = DateTimeFormatUtil.getDateFormatyyyyMMdd().parse(dateOfDept); 
			this.dateOfDept = date;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	
	
}
