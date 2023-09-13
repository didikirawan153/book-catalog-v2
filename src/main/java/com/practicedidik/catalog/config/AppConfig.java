package com.practicedidik.catalog.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.practicedidik.catalog.domain.Author;
import com.practicedidik.catalog.domain.Book;
import com.practicedidik.catalog.repository.BookRepository;
import com.practicedidik.catalog.repository.impl.BookRepositoryImpl;

@ComponentScan(basePackages = {"com.latihandidik"})
@Configuration
public class AppConfig {
	
	@Bean
	public Author author() {
		return new Author(1L, "Pramoedya ananta toer", -16401L);
	}
	
	@Bean
	public Book book1(Author author) {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("Buku1");
		book.setDescription("ini tes buku1");
		book.setAuthor(author);
		return book;
	}
	
	@Bean
	public Book book2(Author author) {
		Book book = new Book();
		book.setId(2L);
		book.setTitle("Buku2");
		book.setDescription("ini tes buku2");
		book.setAuthor(author);
		return book;
	}
	
	@Bean
	public BookRepository bookRepository(Book book1, Book book2) {
		Map<Long, Book> bookMap = new HashMap<Long, Book>();
		bookMap.put(1L, book1);
		bookMap.put(2L, book2);
		
		BookRepositoryImpl bookRepositoryImpl = new BookRepositoryImpl();
		bookRepositoryImpl.setBookMap(bookMap);
		
		return bookRepositoryImpl;
	}
	
//	@Bean
//	public BookService bookService(BookRepository bookRepository) {
//		return new BookServiceImpl(bookRepository);
//	}
}
