package com.kevintruong.jdbcexample1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnUtils {
	
	//get connection
	public static Connection getOracleConnection() throws  SQLException,ClassNotFoundException {
		
		String hostName = "localhost";
		String sid  = "orcl";
		String userName = "kevintruong1";
		String password = "1234";
		
		return getOracleConnection(hostName,sid,userName,password);
	}
	
	public static Connection getOracleConnection(String hostName,String sid,String userName, String password) throws SQLException,ClassNotFoundException {
		
		// below fix for java 6
//	     Class.forName("oracle.jdbc.driver.OracleDriver");
		String connectionURL = "jdbc:oracle:thin:@"+hostName + ":1521:" +sid ;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn ;
	}
	
}
