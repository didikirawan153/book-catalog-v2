package com.practicedidik.catalog.repository.impl;

import java.util.ArrayList;
import java.util.List;
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

	@Override
	public List<Book> findBookAll() {
		List<Book> listBook = new ArrayList<Book>(bookMap.values());
		return listBook;
	}

	@Override
	public void save(Book book) {
		int size = bookMap.size();
		book.setId((long) (size+1));
		bookMap.put(book.getId(), book);		
	}

	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		bookMap.put(book.getId(), book);
	}

	@Override
	public void delete(Long id) {
		bookMap.remove(id);		
	}

}
