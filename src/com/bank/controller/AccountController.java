package com.bank.controller;

import com.bank.exception.InsufficientBalance;
import com.bank.exception.InvalidAccountException;
import com.bank.exception.InvalidPin;
import com.bank.model.User;
import com.bank.service.AccountService;
import com.bank.service.PinService;
//import com.bank.service.PinService;
import com.bank.service.UserService;

public class AccountController {
	
	public long createAccount(User user) {
		UserService userService = new UserService();
//		User user = userService.createUser();
		
		AccountService accountService = new AccountService();
		long accountNumber = accountService.generateAccountNumber();
		
		user.setAccountNumber(accountNumber);
		userService.saveUser(user);
		
		return accountNumber;
	}
	
	public double getAccountBalance(long accountNumber, int userPin) throws InvalidAccountException, InvalidPin {
		PinService pinService = new PinService();
		pinService.authenticateUser(accountNumber, userPin);
		
		AccountService accountService = new AccountService();
		return accountService.getBalance(accountNumber);
	}
	
	public double deposit(long accountNumber, double amount, int userPin) throws InvalidAccountException, InvalidPin {
		PinService pinService = new PinService();
		pinService.authenticateUser(accountNumber, userPin);
		
		AccountService accountService = new AccountService();
		accountService.deposit(accountNumber, amount);
		
		return accountService.getBalance(accountNumber);
	}
	
	public double withdraw(long accountNumber, double amount, int userPin) throws InvalidAccountException, InsufficientBalance, InvalidPin {
		PinService pinService = new PinService();
		pinService.authenticateUser(accountNumber, userPin);

		AccountService accountService = new AccountService();
		accountService.withdraw(accountNumber, amount);
		
		return accountService.getBalance(accountNumber);
	}

}
