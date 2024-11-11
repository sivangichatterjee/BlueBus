package com.nrifintech.bms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="BUS_STOP")
public class BusStop extends AbstractBaseEntity {
	private static final long serialVersionUID = 6715094082833854125L;
	
	@Id 
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STOP_CODE")
  	private Long stopCode;

	@Column(name = "STOP_NAME", length = 80, nullable = false, unique = true)
	private String stopName;
	
	public BusStop() {
		
	}
	
	public BusStop(String stopName) {
		this.stopName = stopName;
	}

	public String getStopName() {
		return stopName;
	}

	public void setStopName(String stopName) {
		this.stopName = stopName;
	}

	public Long getStopCode() {
		return stopCode;
	}
	
	
	
	
}
