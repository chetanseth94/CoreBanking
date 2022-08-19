package com.bank;

import java.sql.SQLException;
import java.sql.Statement;

import com.bank.dao.AccountDao;
import com.bank.dao.UserDao;
import com.bank.jdbc.DbConnection;

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
		
		
		
		
//		ResultSet rs = stmt.executeQuery("select * from product");
//		
//		while (rs.next()) {
//			System.out.println(rs.getString(1) + ":" + rs.getString(2) + ":" + rs.getInt(4));
//		}
	}

}
