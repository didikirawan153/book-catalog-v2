package com.practicedidik.catalog.repository.impl;

import java.util.Map;

import com.practicedidik.catalog.domain.Book;
import com.practicedidik.catalog.repository.BookRepository;

import lombok.Data;

@Data
public class BookRepositoryImpl implements BookRepository{

	private Map<Long, Book> bookMap;
	
	@Override
	public Book findBookById(Long id) {
		Book book = bookMap.get(id);
		return book;
	}

}
