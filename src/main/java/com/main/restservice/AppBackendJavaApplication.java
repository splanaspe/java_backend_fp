package com.main.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class AppBackendJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBackendJavaApplication.class, args);
	}

}
