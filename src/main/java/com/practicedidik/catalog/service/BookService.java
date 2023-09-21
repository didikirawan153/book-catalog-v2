package com.practicedidik.catalog.service;

import java.util.List;

import com.practicedidik.catalog.domain.dto.BookDetailDto;
import com.practicedidik.catalog.domain.dto.CreateBookDto;
import com.practicedidik.catalog.domain.dto.UpdateBookDto;

public interface BookService {

	public BookDetailDto findBookById(Long id);
	
	public List<BookDetailDto> findBookAll();
	
	public void createBook(CreateBookDto createBookDto);
	
	public void updateBook(Long id, UpdateBookDto dto);
	
	public void deleteBook(Long id);
}
