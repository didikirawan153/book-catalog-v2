package com.practicedidik.catalog.web;

import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.practicedidik.catalog.domain.dto.BookDetailDto;
import com.practicedidik.catalog.domain.dto.CreateBookDto;
import com.practicedidik.catalog.domain.dto.UpdateBookDto;
import com.practicedidik.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResources {

	private final BookService bookService;
	
	//Penulisan endpoint restful api yg baik adalah berdasarkan resourcenya
	//Ini adalah penulisan yg salah -> /get-book
	//Ini adalah penulisan yg benar -> /book dengan method get
	@GetMapping("/book/{bookId}")
	public BookDetailDto getBookById(@PathVariable("bookId") Long id) {
		StopWatch stopWatch = new StopWatch();
		log.info("Start findBookById with ID : "+id);
		stopWatch.start();
		BookDetailDto result = bookService.findBookById(id);
		log.info("Finish findBookById with ID : "+id+" with time : "+stopWatch.getTotalTimeMillis());
		return result;
	}
	
	//Penulisan endpoint restful api yg baik adalah berdasarkan resourcenya
	//Ini adalah penulisan yg salah -> /create-book /new_book
	//Ini adalah penulisan yg benar -> /book dengan method post
	@PostMapping("/book")
	public ResponseEntity<Void> createNewBook(@RequestBody CreateBookDto dto){
		bookService.createBook(dto);
		return ResponseEntity.created(URI.create("/book")).build();
	}
	
	@GetMapping("/book")
	public ResponseEntity<List<BookDetailDto>> getAllBook(){
		return	ResponseEntity.ok(bookService.findBookAll());
	}
	
	@PutMapping("/book/{id}")
	public ResponseEntity<Void> updateBook(@PathVariable(value = "id") Long id,@RequestBody UpdateBookDto dto){
		bookService.updateBook(id, dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
}
