package com.mysite.springimage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration	//환경설정 어노테이션
public class WebConfig implements WebMvcConfigurer {
	
//	private String connectPath = "/imgs/**";
//	private String resourcePath = "file:///C:/Project/imgs/";
	
	@Value("${custom.connect-path}")//application.yml에 경로 설정
	private String connectPath;
	
	@Value("${custom.image-path}")	//application.yml에 경로 설정
	private String resourcePath;
	
	// ResourceHandlerRegistry : 리소스 등록 및 핸들러를 관리하는 객체힌 registry 를 통해
	// 리소스위치와 이 리소스와 매칭될 url을 등록한다.
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(connectPath)
			.addResourceLocations(resourcePath);
	}
	
}
