package com.bank.service;

import com.bank.dao.UserDao;
import com.bank.exception.InvalidAccountException;
import com.bank.model.UserDetails;

public class UserService {
	
	UserDao userDao = UserDao.getUserDao();
	
	public void saveUser(UserDetails user) {
		userDao.saveUser(user);
		return;
	}
	
	public int getTrueUserPin(int accountNumber) throws InvalidAccountException {
		String PIN = userDao.getTrueUserPin(accountNumber);
		try{
			return Integer.parseInt(PIN);
		} catch(Exception e) {
			System.err.println("Some error occured.");
		}
		return -1;
	}
	
	private UserService(){
	}
	
	private static UserService userService;
	
	public static UserService getUserService() {
		if(userService == null)	return new UserService();
		else	return userService;
	}
}
