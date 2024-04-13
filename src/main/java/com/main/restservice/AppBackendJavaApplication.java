package com.main.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan("com.codeflash.controller")
@EntityScan("com.codeflash.model")
@EnableJpaRepositories("com.codeflash.repository")
@SpringBootApplication
public class AppBackendJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBackendJavaApplication.class, args);
	}

}
