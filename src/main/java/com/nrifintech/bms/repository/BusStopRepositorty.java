package com.nrifintech.bms.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;

import com.nrifintech.bms.entity.BusStop;

public interface BusStopRepositorty extends AbstractBaseRepository<BusStop, Long> {
	
	@Query("SELECT s.stopCode FROM BusStop s WHERE s.stopName = ?1")
	Long findStopCodeByStopName(String stopName);
	
	@Query("SELECT s.stopCode,s.stopName FROM BusStop s")
	List<Object[]> getStations();

	BusStop findByStopName(String stopName);

}
