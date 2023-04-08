package com.mysite.springtest0322;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.mysite.springtest0322") //Mapper를 스캐닝하도록 설정
public class Springtest0322Application {

	public static void main(String[] args) {
		SpringApplication.run(Springtest0322Application.class, args);
	}

}
