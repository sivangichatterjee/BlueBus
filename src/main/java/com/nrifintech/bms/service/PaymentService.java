package com.nrifintech.bms.service;

public interface PaymentService {
	public boolean transaction(Long cardNumber, int cvv, String cardHolderName, int monthOfExp, int yearOfExp);
}
