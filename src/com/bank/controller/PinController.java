package com.bank.controller;

import com.bank.service.PinService;

public class PinController {
	
	private PinService pinService;
	
	public boolean verifyPin(long accountNumber, int pin) {
		return pinService.authenticateUser(accountNumber, pin);
	}
	
	public void forgotPin(long accountNumber, int pin) {
		
	}

	public PinController() {
		pinService = new PinService();
	}
}
