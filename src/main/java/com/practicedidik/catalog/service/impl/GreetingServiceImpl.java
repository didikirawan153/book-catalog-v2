package com.practicedidik.catalog.service.impl;

import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.practicedidik.catalog.config.ApplicationProperties;
import com.practicedidik.catalog.config.CloudProperties;
import com.practicedidik.catalog.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	private ApplicationProperties applicationProperties;
	
	private CloudProperties cloudProperties;
	
	public GreetingServiceImpl(ApplicationProperties applicationProperties, CloudProperties cloudProperties) {
		super();
		this.applicationProperties = applicationProperties;
		this.cloudProperties = cloudProperties;
	}

	@Override
	public String sayGreeting() {
		System.out.println(cloudProperties.getCloudKey());
		TimeZone timeZone = TimeZone.getTimeZone(applicationProperties.getTimezone());
		return applicationProperties.getWelcomeText()+", Our timezone : "+timeZone.getDisplayName()+
				", Our currency : "+applicationProperties.getCurrency();
	}
	
}
