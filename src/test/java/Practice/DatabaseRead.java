package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class DatabaseRead {
	
	@Test
public void readDatadromTable() throws SQLException
{

		com.mysql.jdbc.Driver driverRef=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driverRef);
	
	//connection to database
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qspiders", "root", "root");
	
	//create sql statement
	Statement stat = conn.createStatement();
	
	String query="select * from student";
	
	ResultSet result = stat.executeQuery(query);
	
	while(result.next())
	{
		System.out.println(result.getInt(1)+"\t"+result.getString(2));
	}
		
	
	//close donnection
	conn.close();
	}

}
