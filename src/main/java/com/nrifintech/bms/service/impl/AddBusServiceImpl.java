package com.nrifintech.bms.service.impl;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.nrifintech.bms.entity.Bus;
import com.nrifintech.bms.repository.BusRepository;
import com.nrifintech.bms.request.AddBusRequest;
import com.nrifintech.bms.service.AddBusService;


@Service
@Transactional
public class AddBusServiceImpl extends AbstractBaseServiceImpl<Bus, String> implements AddBusService{
	@Autowired
	private BusRepository busRepository;
	
	public AddBusServiceImpl(BusRepository busRepository) {
		super(busRepository);
		this.busRepository = busRepository;
	}
	
	@Override
	public List<Object[]> BusDetails() {
		//List<Bus> buses = busRepository.findAll();
		List<Object[]> queryResult = busRepository.BusDetails();
		return queryResult;
	}
	
	@Override
	public boolean isDefined(AddBusRequest addBusRequest) {
			
		Bus fetchedBus = busRepository.findByBusCode(addBusRequest.getBusCode());
		
		if(!Objects.isNull(fetchedBus)) return true;
		else return false;
		
	}
}