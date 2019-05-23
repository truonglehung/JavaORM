package com.kevintruong.jdbcexample1.batchprocessing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.kevintruong.jdbcexample1.utils.ConnectionUtils;

public class BatchExample {

	public static void main(String[] args) throws SQLException , ClassNotFoundException{
		// TODO Auto-generated method stub
//		updateMutilpleStatementData();
		insertMutilpleRowPreparedStatement();
	}
	
	public static void updateMutilpleStatementData() throws SQLException , ClassNotFoundException {
		
		Connection conn = ConnectionUtils.getMyConnection();
		Statement stmt = conn.createStatement();
		conn.setAutoCommit(false);
		String strSql1  = "update employee " + 
						"set First_Name = 'Kevin 30' " + 
						"where emp_id='30' " ;
		
		stmt.addBatch(strSql1);
		
		String strSql2  = "update employee " + 
				"set First_Name = 'Kevin 29' " + 
				"where emp_id='29' " ;
		stmt.addBatch(strSql2);
		
		int[] counts = stmt.executeBatch();
		
		System.out.println("Sql1 count = " + counts[0]);
        System.out.println("Sql2 count = " + counts[1]);
        
        conn.commit();
        //
        stmt.close();
        conn.close();
	}
	
	public static void insertMutilpleRowPreparedStatement() throws SQLException , ClassNotFoundException {
		
		Connection conn = ConnectionUtils.getMyConnection();
		String strSql1 = "Insert into Employee( emp_id,FIRST_NAME,LAST_NAME,dept_id,start_date) " + 
				"values (?,?,?,?,to_date(sysdate) ) ";
		PreparedStatement stmt  = conn.prepareStatement(strSql1);
		conn.setAutoCommit(false);
		stmt.setInt(1,33);
		stmt.setString(2, "kevin 33");
		stmt.setString(3, "truong");
		stmt.setInt(4, 3);
		stmt.addBatch();
		//
		
		stmt.setInt(1,34);
		stmt.setString(2, "kevin 34");
		stmt.setString(3, "truong");
		stmt.setInt(4, 3);
		stmt.addBatch();
		
		 int[] counts = stmt.executeBatch();
		
		 System.out.println("counts[0] = " + counts[0]);
         System.out.println("counts[1] = " + counts[1]);
         
         conn.commit();
         stmt.close();
         conn.close();
		
	}
}
