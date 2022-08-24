package com.bank.service;

import java.sql.SQLException;

import com.bank.dao.AccountDao;
import com.bank.exception.InsufficientBalance;
import com.bank.exception.InvalidAccountException;

public class AccountService {
	
	AccountDao accountDao = AccountDao.getAccountDao();

	public int saveAccountNumber() {
		int accountNumber = generateAccountNumber();
		boolean valid = false;
		
		while(!valid) {
			try {
				accountDao.saveAccountNumber(accountNumber);
				valid = true;
			} catch (SQLException e) {
				System.out.println("Generating account number...");
			}
		}
		return accountNumber;
	}
	
	private int generateAccountNumber() {
		int leftLimit = 1;
		int rightLimit = 999999999;
		int accountNumber = 0;
		accountNumber = leftLimit + (int) (Math.random() * (rightLimit - leftLimit));

		return accountNumber;
	}

	public double getBalance(int accountNumber) throws InvalidAccountException {
		String balance = accountDao.getBalance(accountNumber);
		try {
			return Double.parseDouble(balance);
		} catch(Exception e) {
			System.err.println("Some error occured.");
		}
		return -1D;
	}

	public double deposit(int accountNumber, double amount) throws InvalidAccountException{
		double balance = getBalance(accountNumber);

		accountDao.deposit(accountNumber, amount, balance);

		return balance+amount;
	}

	public double withdraw(int accountNumber, double amount) throws InvalidAccountException, InsufficientBalance {
		double balance = getBalance(accountNumber);
		if(balance < amount)	throw new InsufficientBalance("Not enough balance.");

		accountDao.withdraw(accountNumber, amount, balance);
		
		return balance-amount;
	}
	
	private AccountService() {
		
	}
	
	private static AccountService accountService;
	
	public static AccountService getAccountService() {
		if(accountService == null)	return new AccountService();
		else return accountService;
	}
}
