package com.kevintruong.jdbcexample1.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.kevintruong.jdbcexample1.utils.ConnectionUtils;
import com.kevintruong.jdbcexample1.utils.OracleConnUtils;

public class ShowData {

	public static void main(String[] args) throws  SQLException,ClassNotFoundException {
		// TODO Auto-generated method stub
//		withOutUtils();
//		getSpecifyColumn();
		insertStaticData();
	}
	
	public static void getSpecifyColumn() throws SQLException,ClassNotFoundException {
		
		Connection conn = OracleConnUtils.getOracleConnection();
		Statement statement = conn.createStatement();
		String strSQL = "select cust_id, birth_date,first_name from individual ";
		ResultSet result = statement.executeQuery(strSQL);
		while(result.next()) {
			int custid = result.getInt("cust_id");
			Date birthdate = result.getDate("birth_date");
			String firstname= result.getString("first_name");
			System.out.println("cust_id: " +custid);
			System.out.println("" +birthdate);
			System.out.println("" +firstname);
		}
		statement.close();
		conn.close();
	}
	
	public static void insertStaticData() throws SQLException,ClassNotFoundException{
		Connection conn = ConnectionUtils.getMyConnection();
		Statement st = conn.createStatement();
		
		String sqlStr = "insert into employee(emp_id,first_name,last_name,start_date,title) \r\n" + 
				"values ('21','hung3','le hung',current_date,'Teller') \r\n" ;
//		int rowcount =st.executeUpdate(sqlStr) ;
//		
//		if(rowcount>0) {
//			System.out.println("insert data success ");
//		}else {
//			System.out.println("insert data failed");
//		}
		
		ResultSet resultCount = st.executeQuery(sqlStr);
		if(!resultCount.rowInserted()) {
			System.out.println("insert data success ");
		}else {
			System.out.println("insert data failed");
		}
		
		st.close();
		conn.close();
		
		
	}
	
	public static void withOutUtils() {

		 final String hostName = "localhost";
		 final String sid = "orcl";
		 final String userName = "kevintruong1";
		 final String password = "1234";

		 final String ConnectionUrl = "jdbc:oracle:thin:@"+hostName + ":1521:" +sid ;

		try {
			Connection conn = DriverManager.getConnection(ConnectionUrl, userName, password);
			Statement st = conn.createStatement();
			  String strSql = "select emp_id,first_name from employee";
			ResultSet result = st.executeQuery(strSql);
			while (result.next()) {
				System.out.println("EmpId:" + result.getInt("emp_id"));
				System.out.println("first_name:" + result.getString("first_name"));
				
			}
			conn.close();
		} catch (SQLException ex) {

		}

	}

}
