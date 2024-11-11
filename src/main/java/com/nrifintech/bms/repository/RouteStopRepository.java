package com.nrifintech.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nrifintech.bms.entity.RouteStop;
import com.nrifintech.bms.entity.RouteStopKey;

public interface RouteStopRepository extends AbstractBaseRepository<RouteStop, RouteStopKey> {
	
	List<RouteStop> findByIdStopCode(Long stopCode);
	
	@Query("SELECT rs.distanceFromStart FROM RouteStop rs WHERE rs.id.routeNum = ?1 AND rs.id.stopCode = ?2")
	float findDistanceByRouteAndStopCode(Long routeNum, Long stopCode);
}