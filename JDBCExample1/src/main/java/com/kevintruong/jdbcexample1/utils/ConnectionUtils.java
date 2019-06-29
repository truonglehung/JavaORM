package com.kevintruong.jdbcexample1.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.kevintruong.jdbcexample1.utils.OracleConnUtils;

public class ConnectionUtils {
	
	public static Connection getMyConnection() throws SQLException,ClassNotFoundException {
		
		return OracleConnUtils.getOracleConnection();
	}
	//for testing connection
	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		 System.out.println("Get connection ... ");
	      // Lấy ra đối tượng Connection kết nối vào database.
	      Connection conn = ConnectionUtils.getMyConnection();
	 
	      System.out.println("Get connection " + conn);
	 
	      System.out.println("Done!");
	}

}
