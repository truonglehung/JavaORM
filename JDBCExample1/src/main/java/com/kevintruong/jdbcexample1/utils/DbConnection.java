package com.kevintruong.jdbcexample1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private static final String DB_DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION_UR = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DB_USERNAME = "kevintruong1";
	private static final String DB_PASSWORD = "1234";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		// load the Driver Class,just using on java6
		Class.forName(DB_DRIVER_CLASS);
		Connection conn = DriverManager.getConnection(DB_CONNECTION_UR, DB_USERNAME, DB_PASSWORD);

		return conn;
	}
	
	public static void main(String[] args)  throws SQLException, ClassNotFoundException {
		DbConnection dbconn = new DbConnection();
		Connection conn =   dbconn.getConnection();
		System.out.println("Connection: "+conn);
	}
}
