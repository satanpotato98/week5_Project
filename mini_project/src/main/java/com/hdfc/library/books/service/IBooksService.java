package com.hdfc.library.books.service;

import java.util.List;

import com.hdfc.library.books.entity.Books;
import com.hdfc.library.books.exceptions.BookNotFoundException;

public interface IBooksService {

	public Books addBook(Books book);
	public Books updateBook(Books book);
	public void deleteBooksById(int id) throws BookNotFoundException;
	public List<Books> getAllBooks();
	Books findByTitle(String title) throws BookNotFoundException;
	
	
}
