package com.nrifintech.bms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ROUTE")
public class Route extends AbstractBaseEntity {
	private static final long serialVersionUID = 6715094082833854125L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROUTE_NUMBER")
	private Long routeNum;
	
	@Column(name = "ROUTE_CODE", unique = true, length = 80)
	private String routeCode;
	
	@JsonIgnore
	@OneToMany(mappedBy = "route", cascade = CascadeType.REMOVE)
	List<Bus> busList = new ArrayList<Bus>();
	
	public Route(long routenum) {
			routeNum = routenum;
	}

	public Route(String routeCode) {
		this.routeCode = routeCode;
	}
	

	public Route() {
		super();
	}

	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public List<Bus> getBusList() {
		return busList;
	}

	public void setBusList(List<Bus> busList) {
		this.busList = busList;
	}

	public Long getRouteNum() {
		return routeNum;
	}
}
