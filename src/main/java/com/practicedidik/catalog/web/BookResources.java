package com.practicedidik.catalog.web;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practicedidik.catalog.domain.dto.BookDetailDto;
import com.practicedidik.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResources {

	private final BookService bookService;
	
	@GetMapping("/book/{bookId}")
	public BookDetailDto getBookById(@PathVariable("bookId") Long id) {
		StopWatch stopWatch = new StopWatch();
		log.info("Start findBookById with ID : "+id);
		stopWatch.start();
		BookDetailDto result = bookService.findBookById(id);
		log.info("Finish findBookById with ID : "+id+" with time : "+stopWatch.getTotalTimeMillis());
		return result;
	}
}
