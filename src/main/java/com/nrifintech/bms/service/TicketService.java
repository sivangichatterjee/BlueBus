package com.nrifintech.bms.service;



import com.nrifintech.bms.entity.Ticket;
import com.nrifintech.bms.request.TicketCancelRequest;

public interface TicketService extends AbstractBaseService<Ticket, Long>{
	
	public boolean isValidPnr(TicketCancelRequest ticketCancelRequest);
	public void deletePnr(TicketCancelRequest ticketCancelRequest);

}