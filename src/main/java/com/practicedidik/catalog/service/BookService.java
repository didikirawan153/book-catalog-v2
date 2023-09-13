package com.practicedidik.catalog.service;

import com.practicedidik.catalog.domain.dto.BookDetailDto;

public interface BookService {

	public BookDetailDto findBookById(Long id);
}
