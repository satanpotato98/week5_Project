package com.hdfc.library.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.library.books.entity.Books;
import com.hdfc.library.books.exceptions.BookNotFoundException;
import com.hdfc.library.books.repository.IBooksRepo;

@Service
public class BooksService implements IBooksService {

	@Autowired
	IBooksRepo repo;
	
	@Override
	public Books addBook(Books book) {
		// TODO Auto-generated method stub
		return repo.save(book);
	}

	@Override
	public Books updateBook(Books book) {
		// TODO Auto-generated method stub
		return repo.save(book);
	}

	@Override
	public void deleteBooksById(int id) throws BookNotFoundException{
		repo.deleteById(id);

	}

	@Override
	public List<Books> getAllBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Books findByTitle(String title) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return repo.findByTitle(title);
	}
	
	



}
