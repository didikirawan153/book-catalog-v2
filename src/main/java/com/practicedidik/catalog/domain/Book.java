package com.practicedidik.catalog.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3358236346711788308L;
	
	private Long id;

	private String title;

	private String Description;

	private Author author;

}
