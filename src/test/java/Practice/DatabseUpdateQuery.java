package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class DatabseUpdateQuery {
	
	
	@Test
	public void updateDb() throws SQLException
	{	
	Driver driverRef=new Driver();
	DriverManager.registerDriver(driverRef);
	
	
	
	// Step 2: get the connection with database // give db name
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");

			// Step 3: Issue Create Statement
			Statement state = con.createStatement();

			// Step 4: Execute a query // give table name
			String query = "insert into student values(2,'akhi'),(3,'simmi akhi');";
			int result = state.executeUpdate(query);
			System.out.println(result);
			if(result==2)
			{
				System.out.println("data is added");
			}
			else
			{
				System.out.println("data not added");
			}
			
			
			String query1="select * from student";
			ResultSet rs1 = state.executeQuery(query1);
			
			while(rs1.next())
			{
				System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2));
			}
			
			// Step 5: Close the database
			con.close();
			System.out.println("db closed");
	}

}
