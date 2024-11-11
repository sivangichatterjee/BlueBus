package com.nrifintech.bms.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lowagie.text.DocumentException;
import com.nrifintech.bms.model.PerbusQuery;
import com.nrifintech.bms.model.QueryDetails;
import com.nrifintech.bms.model.RevenueQuery;
import com.nrifintech.bms.model.RouteQuery;
import com.nrifintech.bms.reportDownloader.PerBusExcel;
import com.nrifintech.bms.reportDownloader.PerBusPdf;
import com.nrifintech.bms.reportDownloader.RevenueBusExcel;
import com.nrifintech.bms.reportDownloader.RevenueBusPdf;
import com.nrifintech.bms.reportDownloader.RouteMigExcel;
import com.nrifintech.bms.reportDownloader.RouteMigPdf;
import com.nrifintech.bms.service.ReportQueryService;

@Controller

public class QueryController {
	
	private List<Object[]> queryResult;

	public static List<RouteQuery> convertRoute(List<Object[]> queryResult) {
		MathContext precision= new MathContext(3);
		List<RouteQuery> queryResultRoute = new ArrayList<RouteQuery>();

		for (Object[] result : queryResult) {

			BigInteger rn = (BigInteger) result[0];
			String rc = (String) result[1];
			BigDecimal sb = (BigDecimal) result[2];
			BigDecimal sc = (BigDecimal) result[3];
			BigDecimal pc = ((BigDecimal) result[4]).round(precision);

			RouteQuery obj = new RouteQuery(rn, rc, sb, sc, pc);

			queryResultRoute.add(obj);
		}
		return queryResultRoute;
	}

	public List<RevenueQuery> convertRevenue(List<Object[]> queryResult) {

		List<RevenueQuery> queryResultRevenue = new ArrayList<RevenueQuery>();

		for (Object[] result : queryResult) {

			String bc = (String) result[0];
			String rc = (String) result[1];
			Double rv = (Double) result[2];

			RevenueQuery obj = new RevenueQuery(bc, rc, rv);

			queryResultRevenue.add(obj);
		}
		return queryResultRevenue;
	}

	public static List<PerbusQuery> convertPerBus(List<Object[]> queryResult) {

		List<PerbusQuery> queryResultPerBus = new ArrayList<PerbusQuery>();

		for (Object[] result : queryResult) {

			String bc = (String) result[0];
			String rc = (String) result[1];
			BigDecimal sb = (BigDecimal) result[2];

			PerbusQuery obj = new PerbusQuery(bc, rc, sb);

			queryResultPerBus.add(obj);
		}

		return queryResultPerBus;
	}

	@Autowired
	private ReportQueryService queryservice;

	@GetMapping("/downloadPdfFile")
	public void exportToPdf(HttpServletResponse response, QueryDetails queryDetails)
			throws DocumentException, IOException {

		response.setContentType("application/octet-stream");

		String query = queryDetails.getReport_type();
		Date d1 = queryDetails.getFrom_date();
		Date d2 = queryDetails.getTo_date();

		if (query.equalsIgnoreCase("route")) {
			response.setHeader("Content-Disposition",
					"attachment; filename=RouteMigration("+d1.toString()+"to"+d2.toString()+").pdf");
//			List<Object[]> queryResult = queryservice.routeMigration(d1, d2);
			RouteMigPdf exporter = new RouteMigPdf(convertRoute(this.queryResult), d1, d2);
			exporter.export(response);
		} else if (query.equalsIgnoreCase("revenue")) {
			response.setHeader("Content-Disposition", "attachment; filename=RevenuePerBus("+d1.toString()+"to"+d2.toString()+").pdf");
//			List<Object[]> queryResult = queryservice.revPerBus(d1, d2);
			RevenueBusPdf exporter = new RevenueBusPdf(convertRevenue(this.queryResult), d1, d2);
			exporter.export(response);
		} else {
			response.setHeader("Content-Disposition", "attachment; filename=PerBusData("+d1.toString()+"to"+d2.toString()+").pdf");
//			List<Object[]> queryResult = queryservice.perBusData(d1, d2);
			PerBusPdf exporter = new PerBusPdf(convertPerBus(this.queryResult), d1, d2);
			exporter.export(response);
		}
	}

	@GetMapping("/downloadExcelFile")
	public void exportToExcel(HttpServletResponse response, QueryDetails queryDetails) throws IOException {

		response.setContentType("application/octet-stream");

		String query = queryDetails.getReport_type();
		Date d1 = queryDetails.getFrom_date();
		Date d2 = queryDetails.getTo_date();

		if (query.equalsIgnoreCase("route")) {
			response.setHeader("Content-Disposition", "attachment; filename=RouteMigration("+d1.toString()+"to"+d2.toString()+").xlsx");
//			List<Object[]> queryResult = queryservice.routeMigration(d1, d2);
			RouteMigExcel excelExporter = new RouteMigExcel(convertRoute(this.queryResult), d1, d2);
			excelExporter.export(response);
		} else if (query.equalsIgnoreCase("revenue")) {
			response.setHeader("Content-Disposition", "attachment; filename=RevenuePerBus("+d1.toString()+"to"+d2.toString()+").xlsx");
//			List<Object[]> queryResult = queryservice.revPerBus(d1, d2);
			RevenueBusExcel excelExporter = new RevenueBusExcel(convertRevenue(this.queryResult), d1, d2);
			excelExporter.export(response);
		} else {
			response.setHeader("Content-Disposition", "attachment; filename=PerBusData("+d1.toString()+"to"+d2.toString()+").xlsx");
//			List<Object[]> queryResult = queryservice.perBusData(d1, d2);
			PerBusExcel excelExporter = new PerBusExcel(convertPerBus(this.queryResult), d1, d2);
			excelExporter.export(response);
		}
	}

	@RequestMapping("/report")
	public String showAllData(@ModelAttribute QueryDetails queryDetails, Model model) {
		String query = queryDetails.getReport_type();
		Date d1 = queryDetails.getFrom_date();
		Date d2 = queryDetails.getTo_date();
		
		model.addAttribute("report", queryDetails.getReport_type());
		model.addAttribute("todate", queryDetails.getFrom_date());
		model.addAttribute("fromdate", queryDetails.getTo_date());
		model.addAttribute("data","out");
		if (query != null) {
			if (query.equalsIgnoreCase("route")) {
				this.queryResult = queryservice.routeMigration(d1, d2);
				if(queryResult.size()!=0) {
					model.addAttribute("data", "in");
				}
				model.addAttribute("routeMig", this.queryResult);
			} else if (query.equalsIgnoreCase("revenue")) {
				this.queryResult = queryservice.revPerBus(d1, d2);
				if(queryResult.size()!=0) {
					model.addAttribute("data", "in");
				}
				model.addAttribute("revperbus", this.queryResult);
			} else {
				this.queryResult = queryservice.perBusData(d1, d2);
				if(queryResult.size()!=0) {
					model.addAttribute("data", "in");
				}
				model.addAttribute("perBus", this.queryResult);
			}
		}
		return "report";
	}

}
