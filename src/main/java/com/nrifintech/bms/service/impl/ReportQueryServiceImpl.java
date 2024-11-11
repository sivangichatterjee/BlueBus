package com.nrifintech.bms.service.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrifintech.bms.repository.QueryDAO;
import com.nrifintech.bms.service.ReportQueryService;

@Service
@Transactional
public class ReportQueryServiceImpl implements ReportQueryService {

	@Autowired
	QueryDAO qrepo;

	@Override
	public List<Object[]> routeMigration(Date d1, Date d2) {
		List<Object[]> queryResult = qrepo.routeMigration(d1, d2);
		return queryResult;
	}

	@Override
	public List<Object[]> revPerBus(Date d1, Date d2) {
		List<Object[]> queryResult = qrepo.revenuePerBus(d1, d2);
		return queryResult;
	}

	@Override
	public List<Object[]> perBusData(Date d1, Date d2) {
		List<Object[]> queryResult = qrepo.perBusData(d1, d2);
		return queryResult;
	}

}
