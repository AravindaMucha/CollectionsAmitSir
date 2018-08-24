package com.capgemini.core.lms.dao;

import java.util.List;

import com.capgemini.core.lms.bean.Book;
import com.capgemini.core.lms.exception.LMSException;

public interface LMSDAO {
	public int addBook(Book book) throws LMSException;
	public Book getBook(int bookId) throws LMSException;
	
	public void updateBook(Book book) throws LMSException;
	public Book removeBook(int bookId) throws LMSException;
	
	public List<Book> getBook() throws LMSException;
}
