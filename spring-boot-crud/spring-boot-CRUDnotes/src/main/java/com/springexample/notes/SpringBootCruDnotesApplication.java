package com.springexample.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootCruDnotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCruDnotesApplication.class, args);
	}
}
