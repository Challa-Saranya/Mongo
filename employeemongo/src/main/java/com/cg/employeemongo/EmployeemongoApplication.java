package com.cg.employeemongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg.employeemongo")
public class EmployeemongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemongoApplication.class, args);
		System.out.println("Welcome to Spring Boot with mongo...");
	}

}
