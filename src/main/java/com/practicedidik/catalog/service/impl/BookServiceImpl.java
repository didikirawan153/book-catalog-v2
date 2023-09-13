package com.practicedidik.catalog.service.impl;

import org.springframework.stereotype.Service;

import com.practicedidik.catalog.domain.Book;
import com.practicedidik.catalog.domain.dto.BookDetailDto;
import com.practicedidik.catalog.repository.BookRepository;
import com.practicedidik.catalog.service.BookService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService{

	private final BookRepository bookRepository;
	
	@Override
	public BookDetailDto findBookById(Long id) {
		Book book = bookRepository.findBookById(id);
		
		BookDetailDto bookDetailDto = new BookDetailDto();
		bookDetailDto.setBookId(book.getId());
		bookDetailDto.setBookTitle(book.getTitle());
		bookDetailDto.setDescription(book.getDescription());
		bookDetailDto.setAuthorName(book.getAuthor().getName());
		
		return bookDetailDto;
	}

	
}
