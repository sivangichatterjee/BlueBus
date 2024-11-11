package com.nrifintech.bms.model;

import java.util.Date;

public class BookingResponse {
	private Long pnr;
	private int seatsBooked;
	private String busCode;
	private Date date;
	private Date startTime;
	private Date endTime;
	private String source;
	private String destination;
	private boolean isBooked = false;
	private String msg;
	
	public BookingResponse() {
	}
	public BookingResponse(Long pnr, int seatsBooked, String busCode, Date date) {
		this.pnr = pnr;
		this.seatsBooked = seatsBooked;
		this.busCode = busCode;
		this.date = date;
	}
	public Long getPnr() {
		return pnr;
	}
	public void setPnr(Long pnr) {
		this.pnr = pnr;
	}
	public int getSeatsBooked() {
		return seatsBooked;
	}
	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	public String getBusCode() {
		return busCode;
	}
	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
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
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public boolean isBooked() {
		return isBooked;
	}
	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
