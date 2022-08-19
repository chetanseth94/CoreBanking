package com.bank.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {
	
	public Statement generateStatement() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// step2 create the connection object
		String url = "jdbc:oracle:thin:@localhost:1521/orcl.iiht.tech";
		String userName = "scott";
		String password = "tiger";
		Connection con = DriverManager.getConnection(url, userName, password);

		return con.createStatement();
	}

}
