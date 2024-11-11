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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nrifintech.bms.model.RevenueQuery;

public class RevenueBusExcel {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<RevenueQuery> queryResult;
	private Date d1;
	private Date d2;

	public RevenueBusExcel(List<RevenueQuery> queryResult, Date d1, Date d2) {
		this.queryResult = queryResult;
		this.d1 = d1;
		this.d2 = d2;
		workbook = new XSSFWorkbook();
	}

	private void writeHeaderLine() {

		sheet = workbook.createSheet("RevenuePerBus");
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));

		Row r1 = sheet.createRow(0);

		CellStyle style = StylePdfExcel.excelCellStyle(workbook);

		createCell(r1, 0, "Revenue Per Bus From " + d1.toString() + " to " + d2.toString(), style);
		sheet.autoSizeColumn(0, true);

		Row row = sheet.createRow(1);

		createCell(row, 0, "Rank", style);
		createCell(row, 1, "Bus Code", style);
		createCell(row, 2, "Route Code", style);
		createCell(row, 3, "Revenue Per Bus", style);
		
		for(int i=0;i<4;i++)
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

		if (queryResult.size() != 0) {
			for (RevenueQuery user : queryResult) {

				System.out.println("user " + user);
				Row row = sheet.createRow(rowCount++);
				int columnCount = 0;

				createCell(row, columnCount++, (Integer) (rowCount - 2), style);
				createCell(row, columnCount++, user.getBusCode().toString(), style);
				createCell(row, columnCount++, user.getRouteCode().toString(), style);
				createCell(row, columnCount++, user.getRevenue().toString(), style);

			}
		} else {
			String s = "No data to display";
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