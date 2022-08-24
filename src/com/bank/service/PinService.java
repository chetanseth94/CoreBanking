package com.bank.service;

import com.bank.exception.InvalidAccountException;
import com.bank.exception.InvalidPin;

public class PinService {
	
	UserService userService = UserService.getUserService();
	
	public void authenticateUser(int accountNumber, int userPin) throws InvalidPin, InvalidAccountException {
		int truePin = userService.getTrueUserPin(accountNumber);
		if(userPin != truePin)	throw new InvalidPin("Wrong Pin.");
	}
	
	private PinService() {
		
	}
	
	private static PinService pinService;
	
	public static PinService getPinService() {
		if(pinService == null)	return new PinService();
		else return pinService;
	}

}
