package org.joozis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver"); //외우자
	
		String user= "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 외우자
	
		Connection conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}

}
