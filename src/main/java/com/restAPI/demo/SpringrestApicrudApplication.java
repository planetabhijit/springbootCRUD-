package com.restAPI.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SpringrestApicrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestApicrudApplication.class, args);
	}

}
