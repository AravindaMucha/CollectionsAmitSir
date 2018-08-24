package com.capgemini.core.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDemo 
{
	public void readDataFromDatabase() 
	{
		
		try(Connection con = DBUtil.getConnection())
		{
			Statement stm = con.createStatement();
			
			ResultSet res = stm.executeQuery("select * from student_marks");
		//-----Process ResultSet-----
			
			while(res.next()) {
				int studentCode = res.getInt("student_code");
				int studentYear = res.getInt(2);
				int subject1 = res.getInt(3);
				
			//	System.out.println(studentCode + "\t\t" + studentYear + "\t\t" + subject1);
			}
		}			
		catch(ClassNotFoundException | SQLException e )
		{
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public void insertDataIntoDatabase() 
	{
		Scanner console  = new Scanner(System.in);
		
		System.out.println("Enter Department Name");
		String departmentName = console.next();
		
		System.out.println("Enter Dept code");
		 int departmentcode = console.nextInt();
		 
		
		try(Connection con = DBUtil.getConnection()) 
		{
			/*Statement stm = con.createStatement();
		
			stm.execute("Insert into department_master values(" + departmentcode + ",\'" + departmentName +"\')");
			
			System.out.println("record inserted");
			*/
			
			PreparedStatement pstm = con.prepareStatement("insert into department_master values(?,?)");
			
			pstm.setInt(1, departmentcode);
			pstm.setString(2, departmentName);
			
			pstm.execute();
			System.out.println("record inserted");
			
		} catch(ClassNotFoundException | SQLException e )
		{
			e.printStackTrace();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new PreparedStatementDemo().readDataFromDatabase();
		new PreparedStatementDemo().insertDataIntoDatabase();
		
	}
}
