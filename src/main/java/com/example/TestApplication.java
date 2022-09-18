package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@MapperScan("com.example.test.dao")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TestApplication {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(TestApplication.class);
		SpringApplication.run(TestApplication.class, args);
		logger.warn("<<<<<<<<<<启动成功>>>>>>>>>>");


	}
}
