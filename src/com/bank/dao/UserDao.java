package com.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bank.exception.InvalidAccountException;
import com.bank.model.UserDetails;

public class UserDao {
	
	private static Statement stmt;

	public String getTrueUserPin(int accountNumber) throws InvalidAccountException {
		String getPin = "SELECT pin FROM userdetails WHERE accountnumber = "+accountNumber;
		try {
			ResultSet rs = stmt.executeQuery(getPin);
			if(rs.next())	return rs.getString(1);
		} catch (SQLException e) {
		}
		throw new InvalidAccountException("Account does not exist.");
	}
	
	public void saveUser(UserDetails user) {
		String save = 
			"Insert into USERDETAILS (ACCOUNTNUMBER, FULLNAME, DOB, ADDRESS, PIN) VALUES("
				+ user.getAccountNumber() + ", '"
				+ user.getFullName() + "', '"
				+ user.getDob() + "', '"
				+ user.getAddress() + "', "
				+ user.getPin() + ")"
			;
		try {
			stmt.executeQuery(save);
		} catch (SQLException e) {
			System.err.println("Some error occured.");
		}
		return;
	}
	
	public void setStmt(Statement stmt) {
		UserDao.stmt = stmt;
	}
	
	private UserDao() {
	}
	
	private static UserDao userDao;
	
	public static UserDao getUserDao() {
		if(userDao == null)	return new UserDao();
		else	return userDao;
	}
	
}
