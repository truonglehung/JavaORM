package com.kevintruong.jdbcexample1.transactionExample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

import com.kevintruong.jdbcexample1.utils.ConnectionUtils;

public class TransactionSavepoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
//		Result result = null;
		
		try {
			conn = ConnectionUtils.getMyConnection();
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			String strSql3 = "select emp_id,first_name from employee where emp_id='27' ";
			ResultSet result = stmt.executeQuery(strSql3);
			System.out.println("Before delete empid 27");
			while(result.next()) {
				System.out.println("Emp_id :" + result.getInt("emp_id"));
				System.out.println("FirstName :" + result.getString("first_name"));
			}
			//
			
			String strSql = "delete from employee where emp_id ='27' ";
			//saving point before delete 
			Savepoint savepoint = conn.setSavepoint();
			int rowCount = stmt.executeUpdate(strSql);
			//ResultSet rs = stmt.executeQuery(strSql);
			if(rowCount>0) {
				System.out.println("delete emp_id 27 success");
			}
			System.out.println("rollback delete emp_id 27 ");
			conn.rollback(savepoint);
			conn.commit();
			
			result.close();
			stmt.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					// Roll back transaction
					System.out.println("Transaction is being rolled back.");
					conn.rollback();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}finally {
			
		}
	}
	
}
