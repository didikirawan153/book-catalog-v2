package com.practicedidik.catalog.repository;

import com.practicedidik.catalog.domain.Book;

public interface BookRepository {
	
	public Book findBookById(Long id);
}
