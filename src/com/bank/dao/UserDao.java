package com.bank.dao;

import java.sql.SQLException;
import java.sql.Statement;

import com.bank.model.UserDetails;

public class UserDao {
	
	private static Statement stmt;

	public UserDetails getUserDetails(long accountNumber) {
		// fetch user details
		return null; // return user details
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
			//e.printStackTrace();
		}
		return;
	}
	
	public void setStmt(Statement stmt) {
		UserDao.stmt = stmt;
	}
	
}
