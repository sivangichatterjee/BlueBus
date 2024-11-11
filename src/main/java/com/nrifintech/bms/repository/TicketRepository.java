package com.nrifintech.bms.repository;

import com.nrifintech.bms.entity.Ticket;

public interface TicketRepository extends AbstractBaseRepository<Ticket, Long> {
	Ticket findByPnr(Long pnr);
	
	void deleteByPnr(Long pnr);
}
