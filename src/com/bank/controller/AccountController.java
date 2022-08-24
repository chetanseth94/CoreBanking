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
	
	AccountService accountService = AccountService.getAccountService();
	PinService pinService = PinService.getPinService();
	UserService userService = UserService.getUserService();
	
	public int createAccount(UserDetails user) {		
		int accountNumber = accountService.saveAccountNumber();
		
		user.setAccountNumber(accountNumber);
		
		userService.saveUser(user);
		
		return accountNumber;
	}
	
	public double getAccountBalance(int accountNumber, int userPin) throws InvalidAccountException, InvalidPin {
		pinService.authenticateUser(accountNumber, userPin);
		
		return accountService.getBalance(accountNumber);
	}
	
	public double deposit(int accountNumber, double amount, int userPin) throws InvalidAccountException, InvalidPin {
		pinService.authenticateUser(accountNumber, userPin);
				
		return accountService.deposit(accountNumber, amount);
	}
	
	public double withdraw(int accountNumber, double amount, int userPin) throws InvalidAccountException, InsufficientBalance, InvalidPin {
		pinService.authenticateUser(accountNumber, userPin);

		return accountService.withdraw(accountNumber, amount);
	}

}
