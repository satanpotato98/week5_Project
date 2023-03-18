package com.hdfc.library.books.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hdfc.library.books.entity.Books;
import com.hdfc.library.books.exceptions.BookNotFoundException;

@Repository
public interface IBooksRepo extends MongoRepository<Books, Integer>{

	public Books findByTitle(String title) throws BookNotFoundException;
}
