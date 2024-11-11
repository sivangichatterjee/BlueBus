package com.nrifintech.bms.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RouteStopKey implements Serializable {
	
	@Column(name = "ROUTE_NUMBER")
	private Long routeNum;
	
	@Column(name = "STOP_CODE")
	private Long stopCode;
	
	public RouteStopKey() {
	}

	public RouteStopKey(Long routeNum, Long stopCode) {
		this.routeNum = routeNum;
		this.stopCode = stopCode;
	}

	public Long getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(Long routeNum) {
		this.routeNum = routeNum;
	}

	public Long getStopCode() {
		return stopCode;
	}

	public void setStopCode(Long stopCode) {
		this.stopCode = stopCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(routeNum, stopCode);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		else if(!(obj instanceof RouteStopKey)) {
			return false;
		}
		else {
			RouteStopKey temp = (RouteStopKey) obj;
			if(routeNum.equals(temp.routeNum) && stopCode.equals(temp.stopCode)) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	
}
