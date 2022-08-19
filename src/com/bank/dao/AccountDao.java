package com.bank.dao;

import java.sql.Statement;

public class AccountDao {
	
	private static Statement stmt;
	
	public double getBalance(long accountNumber) {
		//get acc bal from db
		return 0;
	}
	
	public boolean accountExists(long accountNumber) {
		//check if acc No is correct or not
		return true;
	}
	
	public void deposit(long accountNumber, double amount) {
		//deposit and check if successful
		return;
	}
	
	public void withdraw(long accountNumber, double amount) {
		//deposit and check if successful
		return;
	}
	//private double getBalanceDb(long accountNumber)

	public void setStmt(Statement stmt) {
		AccountDao.stmt = stmt;
	}

}
