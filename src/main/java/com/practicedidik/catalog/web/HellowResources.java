package com.practicedidik.catalog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicedidik.catalog.domain.dto.MessageResponseDto;
import com.practicedidik.catalog.service.GreetingService;

@RestController
public class HellowResources {
	
	Logger log = LoggerFactory.getLogger(HellowResources.class);
	
	private GreetingService greetingService;
	

	public HellowResources(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}


	@GetMapping(value = "/hello")
	public ResponseEntity<MessageResponseDto> helloWorld() {
		log.trace("Ini log TRACE");
		log.debug("Ini log DEBUG");
		log.info("Ini log INFO");
		log.warn("Ini log WARN");
		log.error("Ini log ERROR");
		MessageResponseDto dto = new MessageResponseDto();
		dto.setMessage(greetingService.sayGreeting());
		
		return ResponseEntity.ok().body(dto);
	}
}
