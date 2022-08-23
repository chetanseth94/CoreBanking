package com.bank.service;

import com.bank.exception.InvalidAccountException;
import com.bank.exception.InvalidPin;

public class PinService {
	
	public void authenticateUser(int accountNumber, int userPin) throws InvalidPin, InvalidAccountException {
		UserService userService = new UserService();
		int truePin = userService.getTrueUserPin(accountNumber);
		if(userPin != truePin)	throw new InvalidPin("Wrong Pin.");
	}

}
