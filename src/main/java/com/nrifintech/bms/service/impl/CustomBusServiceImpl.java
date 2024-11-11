package com.nrifintech.bms.service.impl;

import java.util.Date;
import java.util.List;


import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrifintech.bms.entity.Bus;
import com.nrifintech.bms.model.BusDetails;
import com.nrifintech.bms.repository.BusRepository;
import com.nrifintech.bms.repository.BusStopRepositorty;
import com.nrifintech.bms.repository.RouteStopRepository;

import com.nrifintech.bms.repository.SearchBusDAO;
import com.nrifintech.bms.service.CustomBusService;
import com.nrifintech.bms.util.DateTimeFormatUtil;

@Service
@Transactional
public class CustomBusServiceImpl implements CustomBusService {
	@Autowired
	private SearchBusDAO customBusDAO;
  
	@Autowired
	private BusRepository busRepo;
	
	@Autowired
	private BusStopRepositorty busStopRepo;
	
	@Autowired
	private RouteStopRepository routeStopRepo;
	
	@Override
	public List<BusDetails> searchAvailableBuses(String startStop, String endStop, String date) {
		return customBusDAO.findBus(startStop, endStop, date);
  }
	
	@Override
	public BusDetails getBusById(String startStop, String endStop, Date date, String busCode) {
		List<BusDetails> result =  customBusDAO.findBusById(startStop, endStop, DateTimeFormatUtil.getDateFormatyyyyMMdd().format(date), busCode);
		if(result.size()==0) {
			return null;
		}
		else {
			return result.get(0);
		}
	}

	@Override
	public List<BusDetails> getBus(String startStop, String endStop, Date date) {
		List<BusDetails> result =  customBusDAO.findBus(startStop, endStop, DateTimeFormatUtil.getDateFormatyyyyMMdd().format(date));
		return result;
	}
	
	@Override
	public double getBusFare(String startStop, String endStop, String busCode) {
		Bus bus = busRepo.findByBusCode(busCode);
		Long routeNum = bus.getRouteNum();
		Long startCode = busStopRepo.findStopCodeByStopName(startStop);
		Long endCode = busStopRepo.findStopCodeByStopName(endStop);
		double distance = routeStopRepo.findDistanceByRouteAndStopCode(routeNum, endCode) - routeStopRepo.findDistanceByRouteAndStopCode(routeNum, startCode);
		return distance*bus.getFarePerKm() + bus.getBasicFare();
	}

}
