package com.nrifintech.bms.model;

import java.math.BigDecimal;
import java.util.Date;

public class BusDetails {

	private String busCode;
	private boolean facilityAc;
	private boolean facilityCharging;
	private boolean facilityPushBackSeat;
	private boolean facilityWater;
	private double totalFare;
	private double seatsRemain;
	private Date startTime;
	private Date endTime;
	
	public BusDetails() {
		
	}

	public BusDetails(String busCode, boolean facilityAc, boolean facilityCharging, boolean facilityPushBackSeat,
			boolean facilityWater, double totalFare, BigDecimal seatsRemain, Date startTime, Date endTime) {
		this.busCode = busCode;
		this.facilityAc = facilityAc;
		this.facilityCharging = facilityCharging;
		this.facilityPushBackSeat = facilityPushBackSeat;
		this.facilityWater = facilityWater;
		this.totalFare = totalFare;
		this.seatsRemain = seatsRemain.doubleValue();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public boolean isFacilityAc() {
		return facilityAc;
	}

	public void setFacilityAc(boolean facilityAc) {
		this.facilityAc = facilityAc;
	}

	public boolean isFacilityCharging() {
		return facilityCharging;
	}

	public void setFacilityCharging(boolean facilityCharging) {
		this.facilityCharging = facilityCharging;
	}

	public boolean isFacilityPushBackSeat() {
		return facilityPushBackSeat;
	}

	public void setFacilityPushBackSeat(boolean facilityPushBackSeat) {
		this.facilityPushBackSeat = facilityPushBackSeat;
	}

	public boolean isFacilityWater() {
		return facilityWater;
	}

	public void setFacilityWater(boolean facilityWater) {
		this.facilityWater = facilityWater;
	}

	public double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}

	public double getSeatsRemain() {
		return seatsRemain;
	}

	public void setSeatsRemain(double seatsRemain) {
		this.seatsRemain = seatsRemain;
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

