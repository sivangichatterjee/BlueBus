package com.nrifintech.bms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.nrifintech.bms.entity.Route;

public interface RouteRepository extends AbstractBaseRepository<Route, Long> {

	@Query("SELECT r.routeNum FROM Route r")
	List<Object> getRouteNum();
	
}