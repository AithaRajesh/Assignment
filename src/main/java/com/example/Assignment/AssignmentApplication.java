package com.example.Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.Assignment")
public class AssignmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(AssignmentApplication.class, args);
		System.out.println("server started.......");
	}

}
