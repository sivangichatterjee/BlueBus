package com.nrifintech.bms.controller;

import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nrifintech.bms.entity.Bus;
import com.nrifintech.bms.entity.Route;
import com.nrifintech.bms.repository.BusRepository;
import com.nrifintech.bms.repository.RouteRepository;
import com.nrifintech.bms.request.AddBusRequest;
import com.nrifintech.bms.service.AddBusService;
import com.nrifintech.bms.util.DateTimeFormatUtil;

@Controller
public class AddBusController {
	@Autowired 
	private RouteRepository routeRepo;
	
	public List<Object[]> queryResult;
	
	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	private final AddBusService addBusService;
	@Autowired
	public AddBusController( AddBusService addBusService) {
		
		this.addBusService = addBusService;
	}
	
	@RequestMapping("/addBus")
	public String Payment(Model model) {
		this.queryResult = addBusService.BusDetails();
		model.addAttribute("busDetails", this.queryResult);
		return "addBus";
	}
	
	@ModelAttribute("routeNumList")
	public Map<Long, String> getRouteList() {
		Map<Long, String> routeNumList = new HashMap<>();
		List<Route> queryResult = routeRepo.findAll();
		for(Route route : queryResult) {
			routeNumList.put(route.getRouteNum(),route.getRouteCode());
		}
		return routeNumList;		
	}
	
	@PostMapping("/doAdd")
	public @ResponseBody
    String doAdd(@RequestBody AddBusRequest addBus,Model model)
    {
		try {
			
		
		Bus bus = new Bus();
		Route route = new Route(Long.parseLong(addBus.getRoute_code()));
		bus.setRoute(route);
		bus.setBusCode(addBus.getBusCode().toUpperCase());
		bus.setRegNo(addBus.getReg_no().toUpperCase());
		bus.setFarePerKm(addBus.getFare_per_km());
		bus.setBasicFare(addBus.getFare());
		bus.setSeatCount(addBus.getSeat_count());
		String time = addBus.getTime_of_departure();
		Date date = DateTimeFormatUtil.getTimeFormatHHmm().parse(time);
		bus.setTimeDept(new Time(date.getTime()));
		bus.setFacilityAC(false);
		bus.setFacilityCharging(false);
		bus.setFacilityPushBachSeat(false);
		bus.setFacilityWater(false);		
		String ac=addBus.getFacility_ac();
		if(ac.equalsIgnoreCase("true"))
			bus.setFacilityAC(true);
		String water=addBus.getFacility_water();
		if(water.equalsIgnoreCase("true"))
			bus.setFacilityWater(true);
		String pbs=addBus.getFacility_pushback_seat();
		if(pbs.equalsIgnoreCase("true"))
			bus.setFacilityPushBachSeat(true);
		String cp=addBus.getFacility_charging();
		if(cp.equalsIgnoreCase("true"))
			bus.setFacilityCharging(true);
		
		if( bus.getSeatCount()<=0 || bus.getBasicFare()<=0 || bus.getFarePerKm()<=0 || bus.getBusCode().equals("")|| bus.getRegNo().equals(""))
		{
			return "Invalid data";
		}
		if(!addBusService.isDefined(addBus))
		{
			addBusService.save(bus);
			
			return "true";
		}
	
        
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			return "something went wrong";
		}
		return "false";
    }
	

}