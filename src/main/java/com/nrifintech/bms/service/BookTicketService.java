package com.nrifintech.bms.service;

import com.nrifintech.bms.model.PaymentDetailsModel;
import com.nrifintech.bms.model.BookingResponse;

public interface BookTicketService {
	public BookingResponse validateAndBook(PaymentDetailsModel paymentModel);
}
