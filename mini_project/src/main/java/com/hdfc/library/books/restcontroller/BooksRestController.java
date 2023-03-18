package com.hdfc.library.books.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.library.books.entity.Books;
import com.hdfc.library.books.exceptions.BookNotFoundException;
import com.hdfc.library.books.service.IBooksService;

@RestController
@RequestMapping("/library/books")
public class BooksRestController {

	@Autowired
	IBooksService service;
	
	@PostMapping("/add")
	public   Books  addBook(@RequestBody Books book) {
		
			return	service.addBook(book);
		
	}
	
	@PutMapping("/update")
	public Books updateBook(@RequestBody Books book) {
		return service.updateBook(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id) throws BookNotFoundException{
		service.deleteBooksById(id);
		if(id==null) {
			throw new BookNotFoundException("book not found");
		}
		return  new ResponseEntity<String>("Book Deleted ",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Books> getAllBooks(){
		return service.getAllBooks();
	}
	
	@GetMapping("/get/{title}")
	public Books getBookByTitle(@PathVariable String title) throws BookNotFoundException {


		Books book;
		book= service.findByTitle(title);
		if(book == null) {
			throw new BookNotFoundException(title);
		}
		return book;
	}
	
}







