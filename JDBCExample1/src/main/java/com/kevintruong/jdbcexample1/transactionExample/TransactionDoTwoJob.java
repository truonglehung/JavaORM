package com.kevintruong.jdbcexample1.transactionExample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.kevintruong.jdbcexample1.utils.ConnectionUtils;

public class TransactionDoTwoJob {

	public static void main(String[] args) throws SQLException ,ClassNotFoundException{
		// TODO Auto-generated method stub
		Connection conn =  ConnectionUtils.getMyConnection();
		//disable autocommit
		conn.setAutoCommit(false);
		try {
			doJob1(conn);
			doJob2(conn);
			//commit to affect database
			conn.commit();
			System.out.println("Processing Successd ");
		}catch(Exception e) {
			e.printStackTrace();
			//rollback if have error,if one or both job1 or have error or both
			conn.rollback();
		}finally {
			conn.close();
		}
		
	}
	private static void doJob1(Connection conn) throws SQLException ,ClassNotFoundException  {
		
		String strSql = "{call INSERTEMPLOYEE(?,?,?,?,?)}";
		CallableStatement cstm = conn.prepareCall(strSql);
		cstm.setInt(1, 28);
		cstm.setString(2, "hung6");
		cstm.setString(3, "le hung");
		cstm.setInt(4,3);
		//register output para
		cstm.registerOutParameter(5, java.sql.Types.VARCHAR);
		
		cstm.executeUpdate();
		
		String strSuccess = cstm.getString(5);
		System.out.println("Insert data employee successd: " + strSuccess);
		
	}
	private static void doJob2(Connection conn)  throws SQLException ,ClassNotFoundException  {
	
		String strSql = "{call INSERTEMPLOYEE(?,?,?,?,?)}";
		CallableStatement cstm = conn.prepareCall(strSql);
		cstm.setInt(1, 30);
		cstm.setString(2, "hung7");
		cstm.setString(3, "le hung");
		cstm.setInt(4,3);
		//register output para
		cstm.registerOutParameter(5, java.sql.Types.VARCHAR);
		
		cstm.executeUpdate();
		
		String strSuccess = cstm.getString(5);
		System.out.println("Insert data employee sucessd: " + strSuccess);
	}
}
