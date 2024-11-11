package com.nrifintech.bms.repository;


import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nrifintech.bms.entity.Bus;

public interface BusRepository extends AbstractBaseRepository<Bus, String> {
	
	Bus findByBusCode(String busCode);
	
	
	
	@Query("SELECT b.busCode, b.regNo, b.farePerKm, b.basicFare, b.seatCount, b.timeDept, b.facilityAC, b.facilityWater, b.facilityCharging, b.facilityPushBachSeat, r.routeCode FROM Bus b, Route r WHERE b.route=r.routeNum ORDER BY b.busCode")
	List<Object[]> BusDetails();
	
	@Query("SELECT b.timeDept FROM Bus b WHERE b.busCode = ?1")
	Time findTimeDeptByBusCode(String busCode);
	
	@Query("SELECT b.basicFare, b.farePerKm FROM Bus b WHERE b.busCode = ?1")		// RETURNS LIST OF LIST AND NOT JUST LIST
	List<List<Double>> findCostByBusCode(String busCode);
	
	@Query("SELECT b.seatCount FROM Bus b WHERE b.busCode = ?1")
	int findSeatsByBusCode(String busCode);
	
	List<Bus> findByRouteRouteNum(Long routeNum);
}
