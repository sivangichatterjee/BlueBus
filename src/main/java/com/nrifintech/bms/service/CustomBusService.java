package com.nrifintech.bms.service;

import java.util.Date;
import java.util.List;

import com.nrifintech.bms.model.BusDetails;

public interface CustomBusService  {

	public List<BusDetails> searchAvailableBuses(String startStop, String endStop, String date);

	public BusDetails getBusById(String startCode, String endCode, Date date, String busCode);
	
	public List<BusDetails> getBus(String startCode, String endCode, Date date);
	
	public double getBusFare(String startCode, String endCode, String busCode); 
}
