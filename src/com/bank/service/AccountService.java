package com.bank.service;

import com.bank.dao.AccountDao;

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

	public double getBalance(long accountNumber) {
		
		AccountDao accountDao = new AccountDao();
		return accountDao.getBalance(accountNumber);
	}

	public void deposit(long accountNumber, double amount) {
		if (accountExists(accountNumber)) {
			AccountDao accountDao = new AccountDao();
			accountDao.deposit(accountNumber, amount);
		}
		else {
			// throw error
		}
	}

	public void withdraw(long accountNumber, double amount) {
		if (accountExists(accountNumber)) {
			if(getBalance(accountNumber) >= amount) {
				AccountDao accountDao = new AccountDao();
				accountDao.withdraw(accountNumber, amount);
			}
			else {
				//in sufficient balance
			}
		}
		else {
			// throw error
		}
	}
}
