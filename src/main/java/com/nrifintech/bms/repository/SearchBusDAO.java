package com.nrifintech.bms.repository;

import java.util.List;

import com.nrifintech.bms.model.BusDetails;

public interface SearchBusDAO {
	public List<BusDetails> findBus(String startStop, String endStop, String date);
	
	public List<BusDetails> findBusById(String startStop, String endStop, String date, String busCode);
	
}
