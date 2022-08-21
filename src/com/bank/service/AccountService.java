package com.bank.service;

import com.bank.dao.AccountDao;
import com.bank.exception.InsufficientBalance;
import com.bank.exception.InvalidAccountException;

public class AccountService {

	public long generateAccountNumber() {
		// generate ac with zero balance
		AccountDao accountDao = new AccountDao();
		accountDao.createAccountNumber();
		return 0;
	}
	
	public boolean accountExists(long accountNumber) {
		AccountDao accountDao = new AccountDao();
		return accountDao.accountExists(accountNumber);
	}

	public double getBalance(long accountNumber) throws InvalidAccountException {
		if (accountExists(accountNumber)) {
			AccountDao accountDao = new AccountDao();
			return accountDao.getBalance(accountNumber);
		}
		else {
			throw new InvalidAccountException("Account does not exist.");
		}
	}

	public void deposit(long accountNumber, double amount) throws InvalidAccountException{
		if (accountExists(accountNumber)) {
			AccountDao accountDao = new AccountDao();
			accountDao.deposit(accountNumber, amount);
		}
		else {
			throw new InvalidAccountException("Invalid account number.");
		}
	}

	public void withdraw(long accountNumber, double amount) throws InvalidAccountException, InsufficientBalance {
		if (accountExists(accountNumber)) {
			if(getBalance(accountNumber) >= amount) {
				AccountDao accountDao = new AccountDao();
				accountDao.withdraw(accountNumber, amount);
			}
			else {
				throw new InsufficientBalance("Not enough balance.");
			}
		}
		else {
			throw new InvalidAccountException("Invalid account number");
		}
	}
}
