package com.nrifintech.bms.entity;

import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import com.nrifintech.bms.model.BusDetails;


@Entity
@Table(name="BUS")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//property = "busCode")
@SqlResultSetMapping(name = "busDetails", classes=	{
	@ConstructorResult(targetClass = BusDetails.class,
			columns = {@ColumnResult(name = "busCode"),
					@ColumnResult(name = "facilityAc"),
					@ColumnResult(name = "facilityCharging"),
					@ColumnResult(name = "facilityPushBackSeat"),
					@ColumnResult(name = "facilityWater"),
					@ColumnResult(name = "totalFare"),
					@ColumnResult(name = "seatRemain"),
					@ColumnResult(name = "startTime"),
					@ColumnResult(name = "endTime")
					})
})
public class Bus extends AbstractBaseEntity {
	private static final long serialVersionUID = 6715094082833854125L;
	
	@Id
	@Column(name = "BUS_CODE", nullable = false, length = 60)
	private String busCode;
	
	@Column(name = "REG_NO", nullable = false, length = 30)
	private String regNo;
	
	@Column(name = "FARE_PER_KM", nullable = false)
	private double farePerKm;
	
	@Column(name = "BASIC_FARE", nullable = false)
	private double basicFare;
	
	@Column(name = "SEAT_COUNT", nullable = false)
	private int seatCount;
	
	@Column(name = "TIME_OF_DEPARTURE", nullable = false)
	private Time timeDept;
	
	@Column(name = "FACILITY_AC")
	private boolean facilityAC;
	
	@Column(name = "FACILITY_WATER")
	private boolean facilityWater;
	
	@Column(name = "FACILITY_CHARGING")
	private boolean facilityCharging;
	
	@Column(name = "FACILITY_PUSH_BACK_SEAT")
	private boolean facilityPushBachSeat;
	
	@ManyToOne
	@JoinColumn(name = "ROUTE_NUMBER", nullable = false)
	private Route route;
	
	public Bus() {
	}

	public Bus(String busCode, String regNo, double farePerKm, double basicFare, int seatCount, Time timeDept,
			boolean facilityAC, boolean facilityWater, boolean facilityCharging, boolean facilityPushBachSeat,
			Route route) {
		this.busCode = busCode;
		this.regNo = regNo;
		this.farePerKm = farePerKm;
		this.basicFare = basicFare;
		this.seatCount = seatCount;
		this.timeDept = timeDept;
		this.facilityAC = facilityAC;
		this.facilityWater = facilityWater;
		this.facilityCharging = facilityCharging;
		this.facilityPushBachSeat = facilityPushBachSeat;
		this.route = route;
	}
	
	

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public double getFarePerKm() {
		return farePerKm;
	}

	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}

	public double getBasicFare() {
		return basicFare;
	}

	public void setBasicFare(double basicFare) {
		this.basicFare = basicFare;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public Time getTimeDept() {
		return timeDept;
	}

	public void setTimeDept(Time timeDept) {
		this.timeDept = timeDept;
	}

	public boolean isFacilityAC() {
		return facilityAC;
	}

	public void setFacilityAC(boolean facilityAC) {
		this.facilityAC = facilityAC;
	}

	public boolean isFacilityWater() {
		return facilityWater;
	}

	public void setFacilityWater(boolean facilityWater) {
		this.facilityWater = facilityWater;
	}

	public boolean isFacilityCharging() {
		return facilityCharging;
	}

	public void setFacilityCharging(boolean facilityCharging) {
		this.facilityCharging = facilityCharging;
	}

	public boolean isFacilityPushBachSeat() {
		return facilityPushBachSeat;
	}

	public void setFacilityPushBachSeat(boolean facilityPushBachSeat) {
		this.facilityPushBachSeat = facilityPushBachSeat;
	}

	public Route getRoute() {
		return route;
	}
	
	public Long getRouteNum() {
		return route.getRouteNum();
	}

	public void setRoute(Route route) {
		this.route = route;
	}
	
}
