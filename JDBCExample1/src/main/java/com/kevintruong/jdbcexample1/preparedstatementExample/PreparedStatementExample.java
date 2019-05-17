package com.kevintruong.jdbcexample1.preparedstatementExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementExample {

	public static void main(String[] args) throws SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
		getColumnWithParaWithoutUtils();
	}
	
	
	
	public static void getColumnWithParaWithoutUtils() throws SQLException,ClassNotFoundException {
		
		String hostname="localhost";
		String sid = "orcl";
		String user = "kevintruong1";
		String password = "1234";
		
		String connectionUrl = "jdbc:oracle:thin:@"+hostname+":1521:"+sid;
		
		Connection conn =DriverManager.getConnection(connectionUrl, user, password);
		String strSql = " select emp_id,first_name ,start_date  from employee where dept_id=? ";
		PreparedStatement prestatement = conn.prepareStatement(strSql) ;
		//set parameter
		prestatement.setInt(1, 2);
		ResultSet rs = prestatement.executeQuery();
		while (rs.next()) {
			System.out.println("EmpId : " + rs.getInt("emp_id"));
			System.out.println("first_name : " + rs.getString("first_name"));
			System.out.println("start_date : " + rs.getDate("start_date"));
		}
//		prestatement.close();
//		conn.close();
		System.out.println("=================================");
		//re-using
		//set parameter again
		prestatement.setInt(1, 3);
		rs = prestatement.executeQuery();
		while (rs.next()) {
			System.out.println("EmpId : " + rs.getInt("emp_id"));
			System.out.println("first_name : " + rs.getString("first_name"));
			System.out.println("start_date : " + rs.getDate("start_date"));
		}
		
		prestatement.close();
		conn.close();
		
	}

}
