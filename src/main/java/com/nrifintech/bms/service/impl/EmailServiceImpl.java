package com.nrifintech.bms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.nrifintech.bms.controller.PaymentController;
import com.nrifintech.bms.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component
public class EmailServiceImpl implements EmailService {

	Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
    private ConfigurableEnvironment  myEnv;
    @Autowired
    private JavaMailSender emailSender;
    @Async
    public void sendTicket(
      String to, String subject, String text) {
        try
        {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom(myEnv.getProperty("spring.mail.username"));
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        emailSender.send(message);
        }
        catch(Exception e)
        {
        	logger.error(e.getMessage());
        }
       
    }
}