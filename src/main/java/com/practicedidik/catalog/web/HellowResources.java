package com.practicedidik.catalog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellowResources {

	@GetMapping(value = "/hello")
	public String helloWorld() {
		return "Hello semuanya ini pertama latihan saya, Didik irawan";
	}
}
