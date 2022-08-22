package com.bank;

import java.sql.SQLException;
import java.sql.Statement;

import com.bank.dao.AccountDao;
import com.bank.dao.UserDao;
import com.bank.jdbc.DbConnection;
import com.bank.view.WelcomeView;

public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//Make connection to the database
		DbConnection dbConnection = new DbConnection();
		Statement stmt = dbConnection.generateStatement();
		
		//Initiate the database connection
		AccountDao accountDao = new AccountDao();
		accountDao.setStmt(stmt);
		UserDao userDao = new UserDao();
		userDao.setStmt(stmt);
		
		System.out.println("****************************");
		System.out.println("Welcome to banking software!");
		System.out.println("****************************");
		System.out.println();
		
		//Start the program
		WelcomeView welcome = new WelcomeView();
		welcome.initiate();
		
		System.out.println();
		System.out.println("*************************************");
		System.out.println("Thank you for using banking software!");
		System.out.println("*************************************");

	}

}
