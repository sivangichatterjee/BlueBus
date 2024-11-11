package com.nrifintech.bms.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nrifintech.bms.entity.Admin;
import com.nrifintech.bms.entity.Ticket;
import com.nrifintech.bms.repository.TicketRepository;
import com.nrifintech.bms.request.TicketCancelRequest;
import com.nrifintech.bms.service.TicketService;



@Service
@Transactional
public class TicketServiceImpl extends AbstractBaseServiceImpl<Ticket, Long> implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	public TicketServiceImpl(TicketRepository ticketRepository) {
		super(ticketRepository);
		this.ticketRepository = ticketRepository;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public boolean isValidPnr(TicketCancelRequest ticketCancelRequest)
	{
		if(Objects.isNull(ticketCancelRequest.getPnr())) {
			return false;
		}
		Ticket fetchedTicket = ticketRepository.findByPnr(ticketCancelRequest.getPnr());
		Date currentTime = Calendar.getInstance().getTime();
		if(!Objects.isNull(fetchedTicket) && fetchedTicket.getDateOfDept().after(currentTime)) return true;
		else return false;
	
	}
	@Override
	public void deletePnr(TicketCancelRequest ticketCancelRequest)
	{
		ticketRepository.deleteByPnr(ticketCancelRequest.getPnr());
	}
	
}