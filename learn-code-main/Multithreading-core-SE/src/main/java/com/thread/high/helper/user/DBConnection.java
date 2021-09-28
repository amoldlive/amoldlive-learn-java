package com.thread.high.helper.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection getConnection() {
		Connection connection = null;
		String connectionURL = "jdbc:mysql://localhost:3306/mydb";
		String userName = "root";
		String password = "admin";

		try {
			//`com.mysql.jdbc.Driver'. This is deprecated
			Class.forName("com.mysql.cj.jdbc.Driver"); // new driver name
			connection = DriverManager.getConnection(connectionURL, userName, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}

}
