package com.nrifintech.bms.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nrifintech.bms.model.BookingResponse;
import com.nrifintech.bms.model.BusDetails;
import com.nrifintech.bms.model.PaymentDetailsModel;
import com.nrifintech.bms.model.PaymentRequestModel;
import com.nrifintech.bms.service.BookTicketService;
import com.nrifintech.bms.service.CustomBusService;
import com.nrifintech.bms.service.EmailService;

import com.nrifintech.bms.util.DateTimeFormatUtil;

@Controller
@RequestMapping("/bookticket")
public class PaymentController {
	
	@Autowired
	Environment env;

	@Autowired
	CustomBusService busService;
	
	@Autowired
	BookTicketService bookTicketService;
  
  @Autowired
	EmailService emailService;

	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	// Cost per seat endpoint
	@GetMapping("ticketprice")
	public @ResponseBody double getCost(@RequestParam("startStop") String startStop, @RequestParam("endStop") String endStop, @RequestParam("busCode") String busCode) {
		double cost = busService.getBusFare(startStop, endStop, busCode);
		return cost;
	}
	
	// Payment Page mapping
	@PostMapping("/payment")
	public ModelAndView getDetails(PaymentRequestModel paymentModel) {
		ModelAndView paymentPage = new ModelAndView("paymentPage");
		
		BusDetails bus = busService.getBusById(paymentModel.getStartStopName(), paymentModel.getEndStopName(), paymentModel.getDateOfDept(), paymentModel.getBusCode());
		
		paymentModel.setStartTime(bus.getStartTime());
		paymentModel.setEndTime(bus.getEndTime());
		
		paymentPage.addObject("busDetails" , paymentModel);
		paymentPage.addObject("maxBookableSeats", env.getProperty("maxSeatsBookable"));
		logger.debug(paymentModel.toString());
		return paymentPage;
	}
	
	@PostMapping("/dopayment")
	public ModelAndView doPayement(@RequestBody PaymentDetailsModel paymentDetails) {
		BookingResponse bookingResponse = bookTicketService.validateAndBook(paymentDetails);
		if(bookingResponse.isBooked() == false) {
			ModelAndView notBooked = new ModelAndView("bookingError");
			notBooked.addObject("msg", bookingResponse.getMsg());
			return notBooked;
		}
		else {
			ModelAndView confirmation = new ModelAndView("bookingConfirmation");
			confirmation.addObject("busCode", bookingResponse.getBusCode());
			confirmation.addObject("dateOfTrip", bookingResponse.getDate());
			confirmation.addObject("pnr", bookingResponse.getPnr());
			confirmation.addObject("seatsBooked", bookingResponse.getSeatsBooked());
			
			//sending mail
			Long pnr = bookingResponse.getPnr();
			String email = paymentDetails.getEmail();
			int seat = bookingResponse.getSeatsBooked();
			String busCode = bookingResponse.getBusCode();
			String startStop = bookingResponse.getSource();
			String endStop = bookingResponse.getDestination();
			String date = DateTimeFormatUtil.getDateFormatddMMMyyyy().format(bookingResponse.getDate());
			String startTime = DateTimeFormatUtil.getTimeFormatHHmm().format(bookingResponse.getStartTime());
			String endTime = DateTimeFormatUtil.getTimeFormatHHmm().format(bookingResponse.getEndTime());

			String message = String.format("Dear Customer,\n\nYour ticket was booked successfully!\nYou have booked %d seats of Bus Code %s from %s to %s for the date %s.\nYour PNR is %d.\nTime of Departure: %s , Time of Arrival: %s.\n\nThank You for using BlueBus",seat, busCode, startStop, endStop, date, pnr, startTime, endTime);

			try {
			emailService.sendTicket(email, "BlueBus", message);
			}
			catch(Exception e)
			{
				logger.error(e.getMessage());
			}
			return confirmation;
			
		}
	}
}