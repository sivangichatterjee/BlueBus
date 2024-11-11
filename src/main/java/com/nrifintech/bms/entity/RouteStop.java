package com.nrifintech.bms.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="ROUTE_STOP")
public class RouteStop extends AbstractBaseEntity {

	private static final long serialVersionUID = 6715094082833854125L;
	
	@EmbeddedId
	private RouteStopKey id = new RouteStopKey();
	
	@ManyToOne
	@MapsId("routeNum")
	@JoinColumn(name="ROUTE_NUMBER")
	Route route;
	
	@ManyToOne
	@MapsId("stopCode")
	@JoinColumn(name="STOP_CODE")
	BusStop busStop;
	
	@Column(name="STOP_ORDER", nullable = false)
	int stopOrder;
	
	@Column(name="DISTANCE_FROM_START", nullable = false)
	float distanceFromStart;
	
	public RouteStop() {
	}

	public RouteStop(Route route, BusStop busStop, int stopOrder, float distanceFromStart) {
		this.route = route;
		this.busStop = busStop;
		this.stopOrder = stopOrder;
		this.distanceFromStart = distanceFromStart;
	}
	
	public RouteStopKey getId() {
		return id;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public BusStop getBusStop() {
		return busStop;
	}

	public void setBusStop(BusStop busStop) {
		this.busStop = busStop;
	}

	public int getStopOrder() {
		return stopOrder;
	}

	public void setStopOrder(int stopOrder) {
		this.stopOrder = stopOrder;
	}

	public float getDistanceFromStart() {
		return distanceFromStart;
	}

	public void setDistanceFromStart(float distanceFromStart) {
		this.distanceFromStart = distanceFromStart;
	}

	
}