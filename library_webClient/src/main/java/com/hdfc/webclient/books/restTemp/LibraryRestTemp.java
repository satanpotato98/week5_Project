package com.hdfc.webclient.books.restTemp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hdfc.webclient.books.entity.Books;

@RestController
@RequestMapping("/books")
public class LibraryRestTemp {

	@Autowired
	RestTemplate restTemplate;
	
	String baseUrl = "http://localhost:9292/library/books";
	
	@GetMapping("/all")
	public   List<Books>  getAll(){
			
			List<Books>  list =restTemplate.getForObject(baseUrl+"/all",List.class);
		
		
			System.out.println(list);
			
			return list;

		
	}
	
	@PostMapping("/add")
	public Books  add(@RequestBody Books book) {
		
		
			
	Books  b =	  restTemplate.postForObject(baseUrl+"/add", book, Books.class);
		
	
	return b;
	}
	
	
}
