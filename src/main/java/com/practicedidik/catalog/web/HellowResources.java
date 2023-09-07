package com.practicedidik.catalog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicedidik.catalog.service.GreetingService;

@RestController
public class HellowResources {
	
	private GreetingService greetingService;
	

	public HellowResources(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}


	@GetMapping(value = "/hello")
	public String helloWorld() {
		return greetingService.sayGreeting();
	}
}
