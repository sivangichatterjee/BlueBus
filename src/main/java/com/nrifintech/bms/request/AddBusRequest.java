package com.nrifintech.bms.request;


import javax.validation.constraints.Pattern;

/**
 * @author DESKTOP
 *
 */
public class AddBusRequest {
	
	@Pattern(regexp = "^(?=.{0,60}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9]+(?<![_.])$", message = "BusCode must have max of 60 characters long with allowed characters - a-z, A-Z, 0-9")
	private  String busCode,route_code;
	private String reg_no;
	private double fare,fare_per_km;
	private String time_of_departure;
	private String facility_ac,facility_water,facility_charging,facility_pushback_seat;
	
	private int seat_count;
	
	public String getReg_no() {
		return reg_no;
	}

	public void setReg_no(String reg_no) {
		this.reg_no = reg_no;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public double getFare_per_km() {
		return fare_per_km;
	}

	public void setFare_per_km(double fare_per_km) {
		this.fare_per_km = fare_per_km;
	}

	public String getTime_of_departure() {
		return time_of_departure;
	}

	public void setTime_of_departure(String time_of_departure) {
		this.time_of_departure = time_of_departure;
	}

	public String getFacility_ac() {
		return facility_ac;
	}

	public void setFacility_ac(String facility_ac) {
		this.facility_ac = facility_ac;
	}

	public String getFacility_water() {
		return facility_water;
	}

	public void setFacility_water(String facility_water) {
		this.facility_water = facility_water;
	}

	public String getFacility_charging() {
		return facility_charging;
	}

	public void setFacility_charging(String facility_charging) {
		this.facility_charging = facility_charging;
	}

	public String getFacility_pushback_seat() {
		return facility_pushback_seat;
	}

	public void setFacility_pushback_seat(String facility_pushback_seat) {
		this.facility_pushback_seat = facility_pushback_seat;
	}

	public int getSeat_count() {
		return seat_count;
	}

	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}	

	public String getRoute_code() {
		return route_code;
	}

	public void setRoute_code(String route_code) {
		this.route_code = route_code;
	}

	public String getBusCode() {
		return busCode;
	}

	public void setBusCode(String busCode) {
		this.busCode = busCode;
	}
	
}