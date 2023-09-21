package com.practicedidik.catalog.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practicedidik.catalog.domain.dto.BookDetailDto;
import com.practicedidik.catalog.domain.dto.CreateBookDto;
import com.practicedidik.catalog.service.BookService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/book")
public class BookController {

	private final BookService bookService;

	@GetMapping(value = "/list")
	public String getAllBook(Model model) {
		List<BookDetailDto> listBook = bookService.findBookAll();
		model.addAttribute("listBook", listBook);
		return "book/list";
	}

	@GetMapping(value = "/new")
	public String newBookRequest(Model model) {
		CreateBookDto dto = new CreateBookDto();
		model.addAttribute("createBookDto", dto);
		return "book/book-new";
	}

	@PostMapping(value = "/new")
	public String createNewBook(@ModelAttribute("createBookDto") @Valid CreateBookDto createBookDto, 
			BindingResult bindingResult,
			Errors errors,
			Model model) {
		if (errors.hasErrors()) {
			model.addAttribute("createBookDto", createBookDto);
			return "book/book-new";
		}
		bookService.createBook(createBookDto);
		return "redirect:/book/list";
	}
}
