package com.bank.controller;

import com.bank.model.User;
import com.bank.service.AccountService;
import com.bank.service.PinService;
import com.bank.service.UserService;

public class AccountController {
	
	public long createAccount() {
		UserService userService = new UserService();
		User user = userService.createUser();
		
		AccountService accountService = new AccountService();
		long accountNumber = accountService.generateAccountNumber();
		
		user.setAccountNumber(accountNumber);
		userService.saveUser(user);
		
		return accountNumber;
	}
	
	public double getAccountBalance(long accountNumber, int userPin) {
		PinService pinService = new PinService();
		if(!pinService.authenticateUser(accountNumber, userPin)) {
			return -1;
		}
		AccountService accountService = new AccountService();
		return accountService.getBalance(accountNumber);
	}
	
	public double deposit(long accountNumber, double amount, int userPin) {
		PinService pinService = new PinService();
		if(!pinService.authenticateUser(accountNumber, userPin)) {
			return -1;
		}
		AccountService accountService = new AccountService();
		accountService.deposit(accountNumber, amount);
		
		return accountService.getBalance(accountNumber);
	}
	
	public double withdraw(long accountNumber, double amount, int userPin) {
		PinService pinService = new PinService();
		if(!pinService.authenticateUser(accountNumber, userPin)) {
			return -1;
		}
		AccountService accountService = new AccountService();
		accountService.withdraw(accountNumber, amount);
		
		return accountService.getBalance(accountNumber);
	}

}
