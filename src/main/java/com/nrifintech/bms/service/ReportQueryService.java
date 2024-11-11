package com.nrifintech.bms.service;

import java.sql.Date;
import java.util.List;


public interface ReportQueryService {

	public List<Object []> routeMigration(Date d1, Date d2);

	public List<Object []> revPerBus(Date d1, Date d2);

	public List<Object []> perBusData(Date d1, Date d2);

}
