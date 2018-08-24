package com.capgemini.core.lms.view;

import com.capgemini.core.lms.bean.Book;
import com.capgemini.core.lms.dao.LMSDAO;
import com.capgemini.core.lms.dao.LMSDAOImpl;
import com.capgemini.core.lms.exception.LMSException;

public class Client {
	
	
	
	
	public static void main(String[] args) {
		LMSDAO lmsDAO = new LMSDAOImpl();
		
		//addBooks
		Book book1 = new Book("BasicJava", "Amit", 1200);
		Book book2 = new Book("Learning PHP", "Ravi", 1100);
		
		int book1Id = 0;
		int book2Id = 0;
		
		try {
			book1Id = lmsDAO.addBook(book1);
			book2Id = lmsDAO.addBook(book2);
			
			System.out.println("Book1 Id: "+book1Id);
			System.out.println("Book2 Id: "+book2Id);
			
		} catch (LMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//===Get books===
		
		try {
			Book book3= lmsDAO.getBook(book1Id);
			Book book4 = lmsDAO.getBook(book2Id);
			
			System.out.println(book3);
			System.out.println(book4);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
