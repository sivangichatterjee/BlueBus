package com.nrifintech.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nrifintech.bms.request.TicketCancelRequest;
import com.nrifintech.bms.service.TicketService;

@Controller
public class TicketController {
	
	private final TicketService ticketService;
	@Autowired
	public TicketController( TicketService ticketService) {
		
		this.ticketService = ticketService;
	}
	
	@RequestMapping("/cancel")
	public String Payment() {
		return "cancel";
	}
	
	@PostMapping("/doCancel")
	public @ResponseBody
    Boolean doCancel(@RequestBody TicketCancelRequest ticket)
    {
		if(ticketService.isValidPnr(ticket))
		{
			ticketService.deletePnr(ticket);
			return true;
		}
        return false;
    }
}