package com.mysite.testspring0322;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.mysite.testspring0322")
public class Testspring0322Application {

	public static void main(String[] args) {
		SpringApplication.run(Testspring0322Application.class, args);
	}

}
