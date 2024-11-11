package com.nrifintech.bms.model;

import java.math.BigDecimal;
import java.math.BigInteger;

public class RouteQuery {
	private BigInteger routeNum;
	private String routeCode;
	private BigDecimal seatBooked;
	private BigDecimal  seatCount;
	private BigDecimal  percentage;
	
	
	public RouteQuery() {
		
	}
	
	public RouteQuery(BigInteger routeNum, String routeCode, BigDecimal  seatBooked, BigDecimal  seatCount, BigDecimal  percentage) {
		this.routeNum = routeNum;
		this.routeCode = routeCode;
		this.seatBooked = seatBooked;
		this.seatCount = seatCount;
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "RouteQuery [routeNum=" + routeNum + ", routeCode=" + routeCode + ", seatBooked=" + seatBooked
				+ ", seatCount=" + seatCount + ", percentage=" + percentage + "]";
	}

	public BigInteger getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(BigInteger routeNum) {
		this.routeNum = routeNum;
	}

	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public BigDecimal getSeatBooked() {
		return seatBooked;
	}

	public void setSeatBooked(BigDecimal seatBooked) {
		this.seatBooked = seatBooked;
	}

	public BigDecimal getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(BigDecimal seatCount) {
		this.seatCount = seatCount;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	

}
