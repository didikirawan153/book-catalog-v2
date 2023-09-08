package com.practicedidik.catalog.service.impl;

import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.practicedidik.catalog.config.AppConfig;
import com.practicedidik.catalog.config.CloudProperties;
import com.practicedidik.catalog.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	private AppConfig appConfig;
	
	private CloudProperties cloudProperties;
	
	public GreetingServiceImpl(AppConfig appConfig, CloudProperties cloudProperties) {
		super();
		this.appConfig = appConfig;
		this.cloudProperties = cloudProperties;
	}

	@Override
	public String sayGreeting() {
		System.out.println(cloudProperties.getCloudKey());
		TimeZone timeZone = TimeZone.getTimeZone(appConfig.getTimezone());
		return appConfig.getWelcomeText()+", Our timezone : "+timeZone.getDisplayName()+
				", Our currency : "+appConfig.getCurrency();
	}
	
}
