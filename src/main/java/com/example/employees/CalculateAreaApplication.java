package com.example.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
each application should only have 1 @SpringbootApplication annotation / entry point
Having more than 1 would confuse the spring boot framework, it does not know where to start the application from
 */
@SpringBootApplication
public class CalculateAreaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateAreaApplication.class, args);
		System.out.println("Spring boot API boilerplate");
	}

}
