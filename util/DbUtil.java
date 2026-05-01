package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private final static String URL = "jdbc:mysql://localhost:3306/service_center_db";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "manger";
	
	public static Connection getConnection() throws SQLException { 
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
