package com.nrifintech.bms.service;



import java.util.List;

import com.nrifintech.bms.entity.Bus;
import com.nrifintech.bms.request.AddBusRequest;

public interface AddBusService extends AbstractBaseService<Bus, String>{
	public boolean isDefined(AddBusRequest addBusRequest);
	public List<Object[]> BusDetails();
}