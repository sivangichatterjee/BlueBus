package com.nrifintech.bms.model;

import java.math.BigDecimal;

public class PerbusQuery {
	
	private String routeCode;
	private String busCode;
	private BigDecimal seatBooked;
	
	public PerbusQuery(String busCode, String routeCode, BigDecimal seatBooked) {
		this.routeCode = routeCode;
		this.busCode = busCode;
		this.seatBooked = seatBooked;
	}

	@Override
	public String toString() {
		return "PerbusQuery [routeCode=" + routeCode + ", busCode=" + busCode + ", seatBooked=" + seatBooked + "]";
	}

	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public BigDecimal getSeatBooked() {
		return seatBooked;
	}

	public void setSeatBooked(BigDecimal seatBooked) {
		this.seatBooked = seatBooked;
	}

}
