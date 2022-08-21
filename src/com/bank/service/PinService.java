package com.bank.service;

import com.bank.exception.InvalidPin;

public class PinService {
	
	public void authenticateUser(long accountNumber, int userPin) throws InvalidPin {
		return;
//		UserService userService = new UserService();
//		int truePin = userService.getUser(accountNumber).getPin();
//		if(userPin != truePin) throw new InvalidPin("Wrong Pin.");
	}

}
