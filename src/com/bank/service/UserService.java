package com.bank.service;

import com.bank.dao.UserDao;
import com.bank.model.User;

public class UserService {
	
	UserDao userDao;

	public User createUser() {
		// get user details
		User user = new User();
		return user;
	}
	
	public void saveUser(User user) {
		//UserDao userDao = new UserDao();
		userDao.saveUser(user);
		return;
	}
	
	public User getUser(long accountNumber) {
		return userDao.getUserDetails(accountNumber);
	}
	
	public UserService(){
		userDao = new UserDao();
	}
}
