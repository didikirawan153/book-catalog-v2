package com.practicedidik.catalog.domain.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDetailDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1996450510295885852L;

	private Long bookId;

	private String authorName;

	private String bookTitle;

	private String description;

}
