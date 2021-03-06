package com.capgemini.core.lms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.core.lms.bean.Book;
import com.capgemini.core.lms.exception.LMSException;

public class LMSDAOImpl implements LMSDAO {

	Map<Integer, Book> books = new HashMap<>();

	private int bookIdValue = 1000;

	public int generateBookId() {
		return ++bookIdValue;
	}

//		//=======returns any value between 1 to 10000======
//		public int generateBookIdRND() {
//			double rndDouble = Math.random();
//			return (int)(rndDouble * 10000);
//		}

	@Override
	public int addBook(Book book) throws LMSException {
		//====set book id by generated by method===
		book.setId(generateBookId());
//		book.setId(generateBookIdRND());
		
		//===add book object as value and its id as key===
		books.put(book.getId(), book);
		
		//====return books generated id===
		return book.getId();
	}

	@Override
	public Book getBook(int bookId) throws LMSException {
		Book book = books.get(bookId);
		
		if(book == null) {
			throw new LMSException("Book not found with id " + bookId);
		}
		return book;
	}

	@Override
	public void updateBook(Book book) throws LMSException {
		
		if(books.containsKey(book.getId()) == false)
			throw new LMSException("No book exists with this book id, Hence update failed");
		
		//=====update if key exists else add=====
		books.put(book.getId(), book);

	}

	@Override
	public Book removeBook(int bookId) throws LMSException {
		
		Book book = books.remove(bookId);
		
		if(book == null)
			throw new LMSException("Remove Failed as no book found with id " + bookId);
		return book;
	}

	@Override
	public List<Book> getBook() throws LMSException {
		
		return new ArrayList<Book>(books.values());
	}

}
