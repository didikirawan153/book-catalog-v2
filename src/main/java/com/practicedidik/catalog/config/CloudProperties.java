package com.practicedidik.catalog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cloud")
public class CloudProperties {

	private String cloudKey;

	public String getCloudKey() {
		return cloudKey;
	}

	public void setCloudKey(String cloudKey) {
		this.cloudKey = cloudKey;
	}
	
}
