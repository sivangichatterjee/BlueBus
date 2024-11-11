package com.nrifintech.bms.model;

import java.util.Date;

public class TravelDetails {
	
	private String source;
	private String destination;
	
	private String traveldate;
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
	public String getTraveldate() {
		return traveldate;
	}
	public void setTraveldate(String traveldate) {
		this.traveldate = traveldate;
	}
	@Override
	public String toString() {
		return "TravelDetails [source=" + source + ", destination=" + destination + ", traveldate=" + traveldate + "]";
	}
}
