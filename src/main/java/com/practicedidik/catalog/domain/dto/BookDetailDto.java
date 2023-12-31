package com.practicedidik.catalog.domain.dto;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
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
