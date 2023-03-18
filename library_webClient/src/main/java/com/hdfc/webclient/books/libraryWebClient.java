package com.hdfc.webclient.books;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.hdfc.webclient.books.entity.Books;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/library/webclient")
public class libraryWebClient {

	String baseUrl = "http://localhost:9292/library/books";
	WebClient webClient = WebClient.create(baseUrl);
	@GetMapping("/all")
	public Mono<List<Books>> getAll() {

		

		Flux<Books> flux = webClient.get().uri("/all").retrieve().bodyToFlux(Books.class);

		flux.doOnNext((emp) -> {
			System.out.println(emp);
		});

		Mono<List<Books>> mono = flux.collectList();

		return mono;

	}
	@PostMapping("/add")
	public Mono<Books> addProduct(@RequestBody Books product){
		Mono<Books> mono=webClient.post().uri("/add").body(Mono.just(product),Books.class).retrieve().bodyToMono(Books.class);
		
		return mono;
	}
	
	@PutMapping("/update")
	public Mono<Books> updateProduct(@RequestBody Books product){
		Mono<Books> mono=webClient.put().uri("/update").body(Mono.just(product),Books.class).retrieve().bodyToMono(Books.class);
		return mono;
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<String> delete(@PathVariable Integer id){
		Mono<String> mono=webClient.delete().
				uri(uriBuilder ->uriBuilder.path("/delete/{id}").
				build(id)).
				retrieve().
				bodyToMono(String.class);
		return mono;
	}
	
	@GetMapping("/get/{title}")
	public Mono<Books> getBookByTitle(@PathVariable String title){
		WebClient webClient = WebClient.create(baseUrl);
		Mono<Books> mono=webClient.get().
				uri("/get/"+title).
				retrieve().
				bodyToMono(Books.class);
		return mono;
	}
}
