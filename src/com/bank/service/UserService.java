package com.bank.service;

import com.bank.dao.UserDao;
import com.bank.model.UserDetails;
//import com.bank.view.NewUser;

public class UserService {
	
	UserDao userDao;

//	public User createUser() {
//		NewUser user = new NewUser();
//		return user.createNewUser();
//	}
	
	public void saveUser(UserDetails user) {
		//UserDao userDao = new UserDao();
		userDao.saveUser(user);
		return;
	}
	
	public UserDetails getUser(long accountNumber) {
		return userDao.getUserDetails(accountNumber);
	}
	
	public UserService(){
		userDao = new UserDao();
	}
}
