package com.nrifintech.bms.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.nrifintech.bms.model.BusDetails;
import com.nrifintech.bms.repository.SearchBusDAO;

@Repository
public class SearchBusDAOImpl implements SearchBusDAO {
	
	@Autowired
	private Environment env;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<BusDetails> findBus(String startStop, String endStop, String date){
		Query query = em.createNativeQuery(String.format("Select bus_code as busCode, facility_ac as facilityAc, facility_charging as facilityCharging, facility_push_back_seat as facilityPushBackSeat, facility_water as facilityWater, total_fare as totalFare, seat_remain as seatRemain, start_time as startTime, end_time as endTime %1$s", env.getProperty("searchBus.sql")), "busDetails");
		query.setParameter(1, startStop);
		query.setParameter(2, endStop);
		query.setParameter(3, date);
		query.setParameter(4, String.format("%1$s>%2$s", startStop, endStop));
		query.setParameter(5,Integer.parseInt(env.getProperty("bus.avg_speed")));
		return query.getResultList();
	}
	
	@Override
	public List<BusDetails> findBusById(String startStop, String endStop, String date, String busCode){
		Query query = em.createNativeQuery(String.format("Select bus_code as busCode, facility_ac as facilityAc, facility_charging as facilityCharging, facility_push_back_seat as facilityPushBackSeat, facility_water as facilityWater, total_fare as totalFare, seat_remain seatRemain, start_time as startTime, end_time as endTime %1$s and bus_code = ?6", env.getProperty("searchBus.sql")), "busDetails");
		query.setParameter(1, startStop);
		query.setParameter(2, endStop);
		query.setParameter(3, date);
		query.setParameter(4, String.format("%1$s>%2$s", startStop, endStop));
		query.setParameter(5,env.getProperty("bus.avg_speed"));
		query.setParameter(6, busCode);
		return query.getResultList();
	}

}
