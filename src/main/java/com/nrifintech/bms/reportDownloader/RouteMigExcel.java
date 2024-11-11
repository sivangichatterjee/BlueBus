package com.nrifintech.bms.reportDownloader;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nrifintech.bms.model.RouteQuery;

public class RouteMigExcel {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<RouteQuery> queryResult;
	private Date d1;
	private Date d2;

	public RouteMigExcel(List<RouteQuery> queryResult, Date d1, Date d2) {
		this.queryResult = queryResult;
		this.d1 = d1;
		this.d2 = d2;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {

		sheet = workbook.createSheet("RouteMig");
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));

		Row r1 = sheet.createRow(0);

		CellStyle style = StylePdfExcel.excelCellStyle(workbook);
		
		createCell(r1, 0, "Route Wise Migration From " + d1.toString() + " to " + d2.toString(), style);
		sheet.autoSizeColumn(0, true);

		Row row = sheet.createRow(1);

		CellStyle style1 = workbook.createCellStyle();
		XSSFFont font1 = workbook.createFont();
		font1.setBold(true);
		font1.setFontHeight(16);
		style1.setFont(font1);

		createCell(row, 0, "Rank", style1);
		createCell(row, 1, "Route Num", style1);
		createCell(row, 2, "Route Code", style1);
		createCell(row, 3, "Seat Booked", style1);
		createCell(row, 4, "Total Seat Count", style1);
		createCell(row, 5, "Seat Booked Percentage", style1);
		
		for(int i=0;i<6;i++)
			sheet.autoSizeColumn(i);

	}

	private void createCell(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell = row.createCell(columnCount);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}

	private void writeDataLines() {
		int rowCount = 2;
		CellStyle style = StylePdfExcel.excelCellStyle(workbook);

		if(queryResult.size()!=0) {
			for (RouteQuery user : queryResult) {
	
				Row row = sheet.createRow(rowCount++);
				int columnCount = 0;
	
				createCell(row, columnCount++, (Integer) (rowCount - 2), style);
				createCell(row, columnCount++, user.getRouteNum().toString(), style);
				createCell(row, columnCount++, user.getRouteCode().toString(), style);
				createCell(row, columnCount++, user.getSeatBooked().toString(), style);
				createCell(row, columnCount++, user.getSeatCount().toString(), style);
				createCell(row, columnCount++, user.getPercentage().toString(), style);
	
			}
		}
		else {
			String s="No data to display";
			Row row = sheet.createRow(rowCount);
			sheet.addMergedRegion(new CellRangeAddress(2, 2, 0, 4));
			createCell(row, 0, s, style);
			sheet.autoSizeColumn(0, true);
		}
	}

	public void export(HttpServletResponse response) throws IOException {
		writeHeaderLine();
		writeDataLines();

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		outputStream.close();

	}
}