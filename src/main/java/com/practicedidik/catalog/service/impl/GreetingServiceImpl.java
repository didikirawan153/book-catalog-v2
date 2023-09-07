package com.practicedidik.catalog.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practicedidik.catalog.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Value("${welcome.text}")
	private String welcomeText;

	@Override
	public String sayGreeting() {
		return welcomeText;
	}
	
}
