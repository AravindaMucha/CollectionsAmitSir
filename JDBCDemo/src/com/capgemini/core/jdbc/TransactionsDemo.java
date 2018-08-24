package com.capgemini.core.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransactionsDemo {
	public static void main(String[] args) {
		try(Connection con = DBUtil.getConnection()){
			
			try {
				con.setAutoCommit(false);
				
				PreparedStatement pstm1 = con.prepareStatement("insert into department_master values(?,?)");
				pstm1.setInt(1, 80);
				pstm1.setString(2, "dept1");
					
				pstm1.execute();
				
				
				PreparedStatement pstm2 = con.prepareStatement("insert into department_master values(?,?)");
				pstm2.setInt(1, 90);
				pstm2.setString(2, "dept2");
					
				pstm2.execute();
				
				con.commit();
				System.out.println("Transaction Commited");
				
			} catch (Exception e) {
				con.rollback();
				System.out.println("Transaction Rolledback");
				e.printStackTrace();
			}
			
			}  catch (Exception e1) {
				
				e1.printStackTrace();
			}
	
	}
}
