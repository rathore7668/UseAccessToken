package pkg1;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection {
	

	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection c=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //registration 
			System.out.println("Inside try after class.forname");
			c=DriverManager.getConnection("Jdbc:Oracle:thin:@localhost:1521:orcl","scott","tiger");

		}catch(Exception e) {
			System.out.println("connection error");
		}
		return c;
	}

	
}
