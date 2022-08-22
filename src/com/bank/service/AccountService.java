package com.bank.service;

import java.sql.SQLException;

import com.bank.dao.AccountDao;
import com.bank.exception.InsufficientBalance;
import com.bank.exception.InvalidAccountException;

public class AccountService {

	public int saveAccountNumber() {
		int accountNumber = generateAccountNumber();
		AccountDao accountDao = new AccountDao();
		boolean valid = false;
		
		while(!valid) {
			try {
				accountDao.saveAccountNumber(accountNumber);
				valid = true;
			} catch (SQLException e) {
				System.out.println("Generating account number...");
				//e.printStackTrace();
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
	
//	public boolean accountExists(int accountNumber) {
//		AccountDao accountDao = new AccountDao();
//		return accountDao.accountExists(accountNumber);
//	}

	public double getBalance(int accountNumber) throws InvalidAccountException {
		AccountDao accountDao = new AccountDao();
		String balance = accountDao.getBalance(accountNumber);
		if (balance != null) {
			return Double.parseDouble(balance);
		}
		else {
			throw new InvalidAccountException("Account does not exist.");
		}
	}

	public double deposit(int accountNumber, double amount) throws InvalidAccountException{
		double balance = getBalance(accountNumber);

		AccountDao accountDao = new AccountDao();
		accountDao.deposit(accountNumber, amount, balance);

		return balance+amount;
	}

	public double withdraw(int accountNumber, double amount) throws InvalidAccountException, InsufficientBalance {
		double balance = getBalance(accountNumber);
		if(balance < amount)	throw new InsufficientBalance("Not enough balance.");

		AccountDao accountDao = new AccountDao();
		accountDao.withdraw(accountNumber, amount, balance);
		
		return balance-amount;
	}
}
