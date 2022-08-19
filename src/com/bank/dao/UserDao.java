package com.bank.dao;

import java.sql.Statement;

import com.bank.model.User;

public class UserDao {
	
	private static Statement stmt;

	public User getUserDetails(long accountNumber) {
		// fetch user details
		return null; // return user details
	}
	
	public void saveUser(User user) {
		// save user into db
		return;
	}
	
	public void setStmt(Statement stmt) {
		UserDao.stmt = stmt;
	}
	
}
