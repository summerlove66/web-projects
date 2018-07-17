package com.hui.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.hui.springboot.mapper")
public class LivestreamWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivestreamWebApplication.class, args);
	}
}
