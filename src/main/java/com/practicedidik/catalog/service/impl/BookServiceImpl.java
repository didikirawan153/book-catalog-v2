package com.practicedidik.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.practicedidik.catalog.domain.Author;
import com.practicedidik.catalog.domain.Book;
import com.practicedidik.catalog.domain.dto.BookDetailDto;
import com.practicedidik.catalog.domain.dto.CreateBookDto;
import com.practicedidik.catalog.domain.dto.UpdateBookDto;
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

	@Override
	public List<BookDetailDto> findBookAll() {
		List<Book> listBook = bookRepository.findBookAll();
		return listBook.stream().map((b)->{
			BookDetailDto dto = new BookDetailDto();
			dto.setAuthorName(b.getAuthor().getName());
			dto.setBookId(b.getId());
			dto.setBookTitle(b.getTitle());
			dto.setDescription(b.getDescription());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public void createBook(CreateBookDto createBookDto) {
		Author author = new Author();
		author.setName(createBookDto.getAuthorName());
		
		Book book = new Book();
		book.setAuthor(author);
		book.setTitle(createBookDto.getBookTitle());
		book.setDescription(createBookDto.getDescription());
		
		bookRepository.save(book);		
	}

	@Override
	public void updateBook(Long id, UpdateBookDto dto) {
		// Get book by id
		 Book book = bookRepository.findBookById(id);
		 
		// Set data book
		book.setTitle(dto.getBookTitle());
		book.setDescription(dto.getDescription());
		 
		// Save update book
		bookRepository.update(book);
		
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.delete(id);		
	}

	
}
