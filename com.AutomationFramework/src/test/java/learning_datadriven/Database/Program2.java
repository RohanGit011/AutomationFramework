package learning_datadriven.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Program2 {
	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			//Driver driverRef=new Driver();
			//DriverManager.registerDriver(driverRef);
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
				Statement st = conn.createStatement();
		
				int result = st.executeUpdate("INSERT INTO Projects (project_id, project_name, owner, team_size) VALUES(133, 'Automation Framework', 'Kanha', 3);");
		
				ResultSet rs = st.executeQuery("select * from projects;");
		
				while(rs.next())
				{
					if(rs.getString(3).equalsIgnoreCase("kanha")) {
						System.out.println("=======Found==========");
						System.out.print(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4));
					}
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
		System.out.println("============Program ends=========");
		
		
	}
		

}
