package com.hdfc.library.books.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<String> handle() {
		return  new ResponseEntity<String>("Not Found",HttpStatus.EXPECTATION_FAILED);
	}
	
	
	
	

}
