package com.capgemini.core.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DatabaseMetaDataDemo {
	public static void main(String[] args) {
		try(Connection con = DBUtil.getConnection()) 
		{
			DatabaseMetaData dataBaseMetaData = con.getMetaData();
			PreparedStatement pstm = con.prepareStatement("select * from Employees");
			
			ResultSet res = pstm.executeQuery();
			ResultSetMetaData resultSetMetaData = res.getMetaData();
			
			
			//---Query Database----
			System.out.println("Database MetaData");
			System.out.println("Database Product name: " + dataBaseMetaData.getDatabaseProductName());
			System.out.println("Does it supports storedProcedures: " + dataBaseMetaData.supportsStoredProcedures());
			
			//---Query Resultset-----
			
			System.out.println("ResultSet MetaData");
			System.out.println("Column count: " + resultSetMetaData.getColumnCount());
			//System.out.println("Is Column Count auto increment: " + resultSetMetaData.);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
