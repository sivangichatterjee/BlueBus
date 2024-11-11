package com.nrifintech.bms.service.impl;

import com.nrifintech.bms.model.PaymentDetailsModel;
import com.nrifintech.bms.repository.BusRepository;
import com.nrifintech.bms.repository.BusStopRepositorty;
import com.nrifintech.bms.repository.TicketRepository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nrifintech.bms.entity.Bus;
import com.nrifintech.bms.entity.BusStop;
import com.nrifintech.bms.entity.Ticket;
import com.nrifintech.bms.model.BookingResponse;
import com.nrifintech.bms.model.BusDetails;
import com.nrifintech.bms.service.BookTicketService;
import com.nrifintech.bms.service.PaymentService;


@Service
public class BookTicketServiceImpl implements BookTicketService {
	
	@Autowired
	CustomBusServiceImpl busService;
	
	@Autowired
	BusRepository busRepo;
	
	@Autowired
	BusStopRepositorty busStopRepo;
	
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	PaymentService paymentService;

	@Override
	@Transactional
	public BookingResponse validateAndBook(PaymentDetailsModel paymentModel) {
		BookingResponse response = new BookingResponse();
		BusDetails busDetails = busService.getBusById(paymentModel.getStartStopName(), paymentModel.getEndStopName(), paymentModel.getBusDate(), paymentModel.getBusCode());
		if(!(busDetails.getSeatsRemain() >= paymentModel.getNumSeats())) {
			response.setMsg("Requested number of seats is greater than max available seats");
		}
		else if(!paymentService.transaction(paymentModel.getCardNum(), paymentModel.getCardCvv(), paymentModel.getCardHolderName(), paymentModel.getMonthExp(), paymentModel.getYearExp())) {
			response.setMsg("Payment was not sucessfull");
		}
		else {
			Bus bus = busRepo.findByBusCode(paymentModel.getBusCode());
			BusStop start = busStopRepo.findByStopName(paymentModel.getStartStopName());
			BusStop end = busStopRepo.findByStopName(paymentModel.getEndStopName());
			Ticket ticket = new Ticket(paymentModel.getNumSeats(), new java.sql.Date(paymentModel.getBusDate().getTime()), paymentModel.getEmail(), bus, start, end);
			ticket = ticketRepo.save(ticket);
			
			response.setBusCode(ticket.getBus().getBusCode());
			response.setPnr(ticket.getPnr());
			response.setSeatsBooked(ticket.getSeatsBooked());
			response.setDate(new Date(ticket.getDateOfDept().getTime()));
			response.setStartTime(busDetails.getStartTime());
			response.setEndTime(busDetails.getEndTime());
			response.setSource(paymentModel.getStartStopName());
			response.setDestination(paymentModel.getEndStopName());
			response.setMsg("Seats Booked");
			response.setBooked(true);
		}
		return response;
	}

}
