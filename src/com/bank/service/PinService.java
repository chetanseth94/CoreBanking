package com.bank.service;

public class PinService {
	
	public boolean authenticateUser(long accountNumber, int userPin) {
		UserService userService = new UserService();
		int truePin = userService.getUser(accountNumber).getPin();
		return userPin == truePin;
	}

}
