package com.nrifintech.bms.model;

public class RevenueQuery {
	
	private String routeCode;
	private String busCode;
	private Double revenue;
	
	public RevenueQuery(String routeCode, String busCode, Double revenue) {
		this.routeCode = routeCode;
		this.busCode = busCode;
		this.revenue = revenue;
	}

	@Override
	public String toString() {
		return "RevenueQuery [routeCode=" + routeCode + ", busCode=" + busCode + ", revenue=" + revenue + "]";
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

	public Double getRevenue() {
		return revenue;
	}

	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}
	

}
