package com.krisbijan.fitit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FitItApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitItApplication.class, args);
	}


}
