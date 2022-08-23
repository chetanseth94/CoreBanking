package com.bank.service;

import com.bank.dao.UserDao;
import com.bank.exception.InvalidAccountException;
import com.bank.model.UserDetails;
//import com.bank.view.NewUser;

public class UserService {
	
	UserDao userDao;
	
	public void saveUser(UserDetails user) {
		//UserDao userDao = new UserDao();
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
	
	public UserService(){
		userDao = new UserDao();
	}
}
