package com.nrifintech.bms.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nrifintech.bms.model.BusDetails;
import com.nrifintech.bms.model.TravelDetails;
import com.nrifintech.bms.repository.BusStopRepositorty;
import com.nrifintech.bms.repository.SearchBusDAO;
import com.nrifintech.bms.service.CustomBusService;

@Controller
public class SearchBusController {
	
	@Autowired
	private BusStopRepositorty busStopRepo;
	
	@Autowired
	private CustomBusService searchBusService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/SearchBus")
	public String ShowBus() {
		return "SearchBus";
	}

	@ModelAttribute("travelDetails")
	public TravelDetails setTravelDetail() {
		return new TravelDetails();
	}

	@ModelAttribute("stationList")
	public Map<Long, String> getStationList() {
		Map<Long, String> stationList = new HashMap<Long, String>();
		List<Object[]> queryResult = busStopRepo.getStations();
		for(Object[] obj : queryResult) {
			Long sCode = (Long)obj[0];
			String sName = (String)obj[1];
			stationList.put(sCode,sName);
		}
		return stationList;		
	}
	
	@PostMapping("/SearchBus")
	public String SearchForBus(@ModelAttribute TravelDetails travelDetails, Model model) {
		return "SearchBus";
	}
	
@RequestMapping("SearchBus/getBusList")
public @ResponseBody List<BusDetails> returnBusList(@ModelAttribute TravelDetails travelDetails, Model model ) {
	return searchBusService.searchAvailableBuses(travelDetails.getSource(), travelDetails.getDestination(), travelDetails.getTraveldate());
	
	}

}
