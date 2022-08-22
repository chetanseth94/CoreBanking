package com.bank.controller;

import com.bank.exception.InsufficientBalance;
import com.bank.exception.InvalidAccountException;
import com.bank.exception.InvalidPin;
import com.bank.model.UserDetails;
import com.bank.service.AccountService;
import com.bank.service.PinService;
//import com.bank.service.PinService;
import com.bank.service.UserService;

public class AccountController {
	
	public int createAccount(UserDetails user) {		
		AccountService accountService = new AccountService();
		int accountNumber = accountService.saveAccountNumber();
		
		user.setAccountNumber(accountNumber);
		
		UserService userService = new UserService();
		userService.saveUser(user);
		
		return accountNumber;
	}
	
	public double getAccountBalance(int accountNumber, int userPin) throws InvalidAccountException, InvalidPin {
		PinService pinService = new PinService();
		pinService.authenticateUser(accountNumber, userPin);
		
		AccountService accountService = new AccountService();
		return accountService.getBalance(accountNumber);
	}
	
	public double deposit(int accountNumber, double amount, int userPin) throws InvalidAccountException, InvalidPin {
		PinService pinService = new PinService();
		pinService.authenticateUser(accountNumber, userPin);
		
		AccountService accountService = new AccountService();
		
		return accountService.deposit(accountNumber, amount);
	}
	
	public double withdraw(int accountNumber, double amount, int userPin) throws InvalidAccountException, InsufficientBalance, InvalidPin {
		PinService pinService = new PinService();
		pinService.authenticateUser(accountNumber, userPin);

		AccountService accountService = new AccountService();
		return accountService.withdraw(accountNumber, amount);
	}

}
