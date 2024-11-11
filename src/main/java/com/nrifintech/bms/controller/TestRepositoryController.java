package com.nrifintech.bms.controller;

import java.sql.Time;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nrifintech.bms.entity.Bus;
import com.nrifintech.bms.entity.RouteStop;
import com.nrifintech.bms.entity.Ticket;
import com.nrifintech.bms.model.BusDetails;
import com.nrifintech.bms.repository.BusRepository;
import com.nrifintech.bms.repository.BusStopRepositorty;
import com.nrifintech.bms.repository.RouteStopRepository;
import com.nrifintech.bms.repository.SearchBusDAO;
import com.nrifintech.bms.repository.TicketRepository;

@Controller
@RequestMapping("/test")
public class TestRepositoryController {
	
	@Autowired
	BusStopRepositorty busStopRepo;
	
	@Autowired
	BusRepository busRepo;
	
	@Autowired
	RouteStopRepository routeStopRepo;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	SearchBusDAO sbdao;
	
//	@GetMapping("/stopcode")
	public @ResponseBody String getStopCode(@RequestParam("city") String city) {
		Long busCode = busStopRepo.findStopCodeByStopName(city);
		System.out.println("******************** Here: "+ busCode);
		return busCode.toString();
	}
	
//	@GetMapping("/bustime")
	public @ResponseBody String getTime(@RequestParam("buscode") String busCode) {
		Time time = busRepo.findTimeDeptByBusCode(busCode);
		System.out.println("******************** Here: "+ time);
		return time.toString();
	}
	
//	@GetMapping("/busforroute")
	public @ResponseBody List<Bus> getBusRoute(@RequestParam("routenum") Long routenum) {
		List<Bus> bus = busRepo.findByRouteRouteNum(routenum);
		System.out.println("******************** Here: "+ bus.size());
		return bus;
	}
	
//	@GetMapping("/costforbus")
	public @ResponseBody List<List<Double>> getCostBus(@RequestParam("buscode") String busCode) {
		List<List<Double>> cost = busRepo.findCostByBusCode(busCode);
		System.out.println("******************** Here: "+ cost.size());
		return cost;
	}
	
//	@GetMapping("/busseat")
	public @ResponseBody int getBusSeat(@RequestParam("routenum") String busCode) {
		int seats = busRepo.findSeatsByBusCode(busCode);
		System.out.println("******************** Here: "+ seats);
		return seats;
	}
	
//	@GetMapping("/routeforstopcode")
	public @ResponseBody List<RouteStop> getRouteForStop(@RequestParam("stopcode") Long stopCode) {
		List<RouteStop> routes = routeStopRepo.findByIdStopCode(stopCode);
		System.out.println("******************** Here: "+ routes.size());
		return routes;
	}
	
//	@GetMapping("/distance")
	public @ResponseBody float getDistanceByRouteStop(@RequestParam("routenum") Long routeNum, @RequestParam("stopcode") Long stopCode) {
		float distance = routeStopRepo.findDistanceByRouteAndStopCode(routeNum, stopCode);
		System.out.println("******************** Here: "+ distance);
		return distance;
	}
	
//	@GetMapping("/pnr")
	public @ResponseBody Ticket getTicketByPNR(@RequestParam("num") Long pnr) {
		Ticket ticket = ticketRepo.findByPnr(pnr);
		System.out.println("******************** Here: "+ ticket);
		return ticket;
	}
	
//	@GetMapping("/deleteticket")
	@Transactional
	public @ResponseBody String deletePNR(@RequestParam("pnr") Long pnr) {
		ticketRepo.deleteByPnr(pnr);
		System.out.println("******************** Here: "+ "Done deleting");
		return "Completed";
	}
	
//	@GetMapping("/checksql")
	public @ResponseBody List<BusDetails> checkSQL() {
		return sbdao.findBus("Howrah", "Digha", "2021-11-01");
	}
	
//	@GetMapping("/checksql2")
	public @ResponseBody List<BusDetails> checkSQL2() {
		return sbdao.findBusById("Howrah", "Digha", "2021-11-01", "BS3020");
	}
}
