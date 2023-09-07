package com.practicedidik.catalog.service.impl;

import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practicedidik.catalog.config.AppConfig;
import com.practicedidik.catalog.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	private AppConfig appConfig;
	
	public GreetingServiceImpl(AppConfig appConfig) {
		super();
		this.appConfig = appConfig;
	}

	@Override
	public String sayGreeting() {
		TimeZone timeZone = TimeZone.getTimeZone(appConfig.getTimezone());
		return appConfig.getWelcomeText()+", Our timezone : "+timeZone.getDisplayName()+
				", Our currency : "+appConfig.getCurrency();
	}
	
}
