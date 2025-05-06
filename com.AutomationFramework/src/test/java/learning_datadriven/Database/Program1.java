package learning_datadriven.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Program1 {
	public static void main(String[] args) throws SQLException {
		
		Connection conn=null;
		
		try {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		Statement st = conn.createStatement();
		 //st.executeQuery("use project;");
		ResultSet rs2 = st.executeQuery("select * from projects;");
		while(rs2.next())
		{
			System.out.printf("%10s",rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\n");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			conn.close();
		}
		
	}

}
