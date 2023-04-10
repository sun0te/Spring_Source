package com.mysite.ocr;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// registry.addMapping을 이용해서 CORS를 적용할 URL 패턴을 정의
		registry.addMapping("/**")
			.allowedOrigins("*");	//allowedOrigins 메소드를 이용해서 자원 공유를 허락할 Origin을 지정 
	}
}
