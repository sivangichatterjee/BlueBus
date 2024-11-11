package com.nrifintech.bms.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.nrifintech.bms.service.PaymentService;
import com.nrifintech.bms.util.DateTimeFormatUtil;


@Service
public class SimplePaymentServiceImpl implements PaymentService {
	
	private Long cardNumber;
	private int cvv;
	private String cardHolderName;
	private int monthOfExp;
	private int yearOfExp;
	
	Logger logger = LoggerFactory.getLogger(SimplePaymentServiceImpl.class);
	
	@Autowired
	public SimplePaymentServiceImpl(@Value("paymentDetails.properties") String propertyName) {
		try(InputStream input = SimplePaymentServiceImpl.class.getClassLoader().getResourceAsStream(propertyName)) {
			Properties property = new Properties();
			property.load(input);
			cardNumber = Long.parseLong(property.getProperty("cardNumber"));
			cvv = Integer.parseInt(property.getProperty("cvv"));
			cardHolderName = property.getProperty("cardHolderName");
			monthOfExp = Integer.parseInt(property.getProperty("monthOfExp"));
			yearOfExp = Integer.parseInt(property.getProperty("yearOfExp"));
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public boolean transaction(Long cardNumber, int cvv, String cardHolderName, int monthOfExp, int yearOfExp) {
		if(cardNumber.equals(this.cardNumber) && cvv == this.cvv && cardHolderName.equals(this.cardHolderName)) {
			int temp_monthOfExp = monthOfExp;
			if(monthOfExp==12) {
				temp_monthOfExp=1;
				yearOfExp += 1;
			}
			else {
				temp_monthOfExp += 1;
			}
			try {				
				Date expDate =DateTimeFormatUtil.getDateFormatyyyyMMdd().parse(String.format("%d-%d-01", yearOfExp, temp_monthOfExp));
				Date today = new Date();
				logger.debug(String.format("Expiry Date: %s", expDate));
				if(expDate.after(today) && monthOfExp == this.monthOfExp && yearOfExp == this.yearOfExp) {
					return true;
				}
				else {
					return false;
				}
			}
			catch(Exception e){
				logger.error(String.format("In payment serive transaction: %s", e.getMessage()));
			}
		}
		return false;
	}

}
