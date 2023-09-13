package com.practicedidik.catalog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.practicedidik.catalog.domain.dto.BookDetailDto;
import com.practicedidik.catalog.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class BookResources {

	private final BookService bookService;
	
	@GetMapping("/book/{bookId}")
	public BookDetailDto getBookById(@PathVariable("bookId") Long id) {
		return bookService.findBookById(id);
	}
}
