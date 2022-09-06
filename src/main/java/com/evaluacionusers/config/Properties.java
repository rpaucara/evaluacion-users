package com.evaluacionusers.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
@RefreshScope
@Component
@ConfigurationProperties
public class Properties {
	 @Value("${application.users.endpoint.user}")
	    private String url;

	public String getUrl() {
		return url;
	}

}
