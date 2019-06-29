package com.kevintruong.jdbcexample1.callablestatementExample;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kevintruong.jdbcexample1.utils.ConnectionUtils;
import com.kevintruong.jdbcexample1.utils.DbConnection;

import oracle.jdbc.OracleTypes;

/*
 * 
 * CREATE OR REPLACE PROCEDURE get_employee_info(
	   p_deptid IN employee.dept_id%TYPE,
	   o_emp_id OUT employee.emp_id%TYPE,
	   o_first_name OUT  employee.first_name%TYPE,
	   o_start_date OUT employee.start_date%TYPE)
	IS
	BEGIN

  SELECT emp_id,first_name,start_date
  INTO o_emp_id, o_first_name,  o_start_date 
  from  employee WHERE dept_id = p_deptid;

	END;
 */
public class CallableStatementExample {

	public static void main(String[] args) throws SQLException,ClassNotFoundException{
		// TODO Auto-generated method stub
//		getEmployeeInfoWithoutUtils();
//		callProcInsertEmployee();
		callProCursorGetMultiEmployee();
	}
	
	public static void getEmployeeInfoWithoutUtils() throws SQLException,ClassNotFoundException {
		//get single row by call procedure
		final String HOSTNAME = "localhost";
		final String SID = "orcl";
		final String USERNAME = "kevintruong1";
		final String PASSWORD = "1234";

		final String CONNECTIONURL = "jdbc:oracle:thin:@" + HOSTNAME + ":1521:" + SID;
		Connection conn =DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
		String strSql = "{call GET_EMPLOYEE_INFO2(?,?,?,?) }" ;
		CallableStatement cstm = conn.prepareCall(strSql);
		//set parameter
		cstm.setInt(1, 2);
		//register out parameter return
		cstm.registerOutParameter(2, java.sql.Types.INTEGER);
		cstm.registerOutParameter(3, java.sql.Types.VARCHAR);
		cstm.registerOutParameter(4, java.sql.Types.DATE);
		//excute query by excuteUpdate
		int rowCount = cstm.executeUpdate();
		if(rowCount>0) {
//			System.out.println("" + cstm.getInt(1));
			System.out.println("" + cstm.getInt(2));
			System.out.println("" + cstm.getString(3));
			System.out.println("" + cstm.getDate(4));
		}
		cstm.close();
		conn.close();
		
	}
	
	public static void callProcInsertEmployee() throws SQLException , ClassNotFoundException {
		
		Connection conn = ConnectionUtils.getMyConnection();
		String strSql = "{call INSERTEMPLOYEE(?,?,?,?,?)}";
		CallableStatement cstm = conn.prepareCall(strSql);
		cstm.setInt(1, 23);
		cstm.setString(2, "hung4");
		cstm.setString(3, "le hung");
		cstm.setInt(4,3);
		//register output para
		cstm.registerOutParameter(5, java.sql.Types.VARCHAR);
		
		cstm.executeUpdate();
		String strSuccess = cstm.getString(5);
		System.out.println("Insert data employee sucessd: " + strSuccess);
		cstm.close();
		conn.close();
	}
	public static void callProCursorGetMultiEmployee() throws SQLException,ClassNotFoundException {
		String output="";
		Connection conn = DbConnection.getConnection();
		String strSql = "{call get_emplist_by_dept(?,?)}";
		CallableStatement cstm = conn.prepareCall(strSql);
		cstm.setInt(1, 30);
		cstm.registerOutParameter(2, OracleTypes.CURSOR);
		//
		cstm.execute();
		ResultSet result = (ResultSet)cstm.getObject(2);
		
		while(result.next()) {
			output = result.getInt("EMP_ID")+"," + result.getString("EMP_NAME") +result.getString("EMP_NO") 
					+"," +result.getDate("HIRE_DATE");
			System.out.println(output);
			output = "";
		}
	}
	
	
}
