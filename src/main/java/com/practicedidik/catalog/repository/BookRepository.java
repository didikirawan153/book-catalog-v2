package com.practicedidik.catalog.repository;

import java.util.List;

import com.practicedidik.catalog.domain.Book;

public interface BookRepository {
	
	public Book findBookById(Long id);
	
	public List<Book> findBookAll();
	
	public void save(Book book);

	public void update(Book book);
	
	public void delete(Long id);
}
