package com.capgemini.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
	
	public static void main(String[] args) {
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
			System.out.println(con.getMetaData().getDatabaseProductName());
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
	}
}
