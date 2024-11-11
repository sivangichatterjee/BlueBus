package com.nrifintech.bms.reportDownloader;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nrifintech.bms.model.RouteQuery;

public class RouteMigPdf {
	private List<RouteQuery> queryResult;
	private Date d1;
	private Date d2;

	public RouteMigPdf(List<RouteQuery> queryResult, Date d1, Date d2) {
		this.queryResult = queryResult;
		this.d1 = d1;
		this.d2 = d2;
	}

	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = StylePdfExcel.pdfCellStyle();
		Font font = StylePdfExcel.pdfFontHeadingStyle();

		cell.setPhrase(new Phrase("Rank", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Route Num", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Route Code", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Seat Booked", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Total Seat Count", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Seat Booked Percentage", font));
		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		int var = 1;
		for (RouteQuery user : queryResult) {
			table.addCell(String.valueOf(var));
			table.addCell(user.getRouteNum().toString());
			table.addCell(user.getRouteCode().toString());
			table.addCell(user.getSeatBooked().toString());
			table.addCell(user.getSeatCount().toString());
			table.addCell(user.getPercentage().toString());
//            table.addCell(String.valueOf(user.isEnabled()));
			var++;
		}
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();
		Font font = StylePdfExcel.pdfFontHeadTopStyle();

		Paragraph p = new Paragraph("Route Wise Migration from " + d1.toString() + " to " + d2.toString(), font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.0f, 1.5f, 1.5f, 2.0f, 2.5f, 3.0f });
		table.setSpacingBefore(10);

		writeTableHeader(table);
		writeTableData(table);

		document.add(table);
		
		if (queryResult.size() == 0) {
			Paragraph p1 = new Paragraph("No data to display", font);
			p.setAlignment(Paragraph.ALIGN_CENTER);

			document.add(p1);
		}

		document.close();

	}
}
