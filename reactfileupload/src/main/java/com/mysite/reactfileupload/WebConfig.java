package com.mysite.reactfileupload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {	//교차출처 정책 처리시 필요
		registry.addMapping("/**")
			.allowedOrigins("*");
	}
}
