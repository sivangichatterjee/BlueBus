package com.nrifintech.bms.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import com.nrifintech.bms.util.DateTimeFormatUtil;

public class PaymentDetailsModel {
	private String busCode;
	
	@DateTimeFormat(pattern = "dd MMM yyyy")
	private Date busDate;
	private String startStopName;
	private String endStopName;
	private int cardCvv;
	private String cardHolderName;
	private Long cardNum;
	private String email;
	private int monthExp;
	private int yearExp;
	private int numSeats;
	private double totalTicketCost;
	
	Logger logger = LoggerFactory.getLogger(PaymentDetailsModel.class);
	
	public PaymentDetailsModel() {
	}

	public PaymentDetailsModel(String busCode, Date busDate, String startStopName, String endStopName, int cardCvv,
			String cardHolderName, Long cardNum, String email, int monthExp, int yearExp, int numSeats,
			double totalTicketCost) {
		this.busCode = busCode;
		this.busDate = busDate;
		this.startStopName = startStopName;
		this.endStopName = endStopName;
		this.cardCvv = cardCvv;
		this.cardHolderName = cardHolderName;
		this.cardNum = cardNum;
		this.email = email;
		this.monthExp = monthExp;
		this.yearExp = yearExp;
		this.numSeats = numSeats;
		this.totalTicketCost = totalTicketCost;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public Date getBusDate() {
		return busDate;
	}

	public void setBusDate(Date busDate) {
		this.busDate = busDate;
	}
	
	public void setBusDate(String busDate) {
		try {
			Date tempDate = DateTimeFormatUtil.getDateFormatddMMMyyyy().parse(busDate);
			this.busDate = tempDate;
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
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

	public int getCardCvv() {
		return cardCvv;
	}

	public void setCardCvv(int cardCvv) {
		this.cardCvv = cardCvv;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public Long getCardNum() {
		return cardNum;
	}

	public void setCardNum(Long cardNum) {
		this.cardNum = cardNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMonthExp() {
		return monthExp;
	}

	public void setMonthExp(int monthExp) {
		this.monthExp = monthExp;
	}

	public int getYearExp() {
		return yearExp;
	}

	public void setYearExp(int yearExp) {
		this.yearExp = yearExp;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public double getTotalTicketCost() {
		return totalTicketCost;
	}

	public void setTotalTicketCost(double totalTicketCost) {
		this.totalTicketCost = totalTicketCost;
	}
	
	@Override
	public String toString() {
		return String.format("BusCode: %s \nBusDate: %s \nStartStopName: %s \nEndStopName: %s \nCardCVV: %d \nCardHolderName: %s \nCardNum: %d \nEmail: %s \nMonthExp: %d \nYearExp: %d \nNumSeats: %d \nTotalTicketCost: %d", busCode, busDate, startStopName, endStopName, cardCvv, cardHolderName, cardNum, email, monthExp, yearExp, numSeats, totalTicketCost);
	}
	
}
