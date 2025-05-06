package com.AutomationFramework.generic.fileutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtility {
	
		Connection conn;
	public void getConnection(String username, String password) throws SQLException{
	try{
			conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/project",username,password);
		}
	catch(Exception e)	{
			e.printStackTrace();
		}
	}
	public void closeDatabase() throws SQLException
	{
		conn.close();
	}
	public ResultSet executeQueryForSelect(String query) throws SQLException
	{
		Statement st = conn.createStatement();
		
		return st.executeQuery(query);
		
	}
	public int executeQueryForNonSelect(String query) throws SQLException
	{
		Statement st = conn.createStatement();
		
		return st.executeUpdate(query);
		
	}


}
