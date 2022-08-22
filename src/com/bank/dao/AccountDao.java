package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDao {
	
	private static Statement stmt;
	
	public void saveAccountNumber(long accountNumber) throws SQLException {
		String save = "Insert into account (ACCOUNTNUMBER, BALANCE) VALUES ("
				+ accountNumber + ", 0)";
		stmt.executeQuery(save);
	}
	
	public String getBalance(int accountNumber) {
		try {
			ResultSet rs = stmt.executeQuery("SELECT balance FROM account WHERE ACCOUNTNUMBER = "
					+ accountNumber);
			if(rs.next()) {
				return rs.getString("balance");
			}
			
		} catch (SQLException e) {
		}
		return null;
	}
	
//	public boolean accountExists(long accountNumber) {
//		//check if acc No is correct or not
//		return true;
//	}
	
	public void deposit(long accountNumber, double amount, double balance) {
		double updatedBalance = amount + balance;
		String deposit = "UPDATE account SET balance = " 
				+ updatedBalance + " WHERE accountnumber = " + accountNumber;
		try {
			stmt.executeQuery(deposit);
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new TransactionFailedException("This transaction has failed.");
		}
	}
	
	public void withdraw(long accountNumber, double amount, double balance) {
		double updatedBalance = balance - amount;
		String withdraw = "UPDATE account SET balance = " 
				+ updatedBalance + " WHERE accountnumber = " + accountNumber;
		try {
			stmt.executeQuery(withdraw);
		} catch (SQLException e) {
			// throw new TransactionFailedException("This transaction has failed.");
		}
	}

	public void setStmt(Statement stmt) {
		AccountDao.stmt = stmt;
	}

}
