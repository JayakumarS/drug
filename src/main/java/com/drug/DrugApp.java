package com.drug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DrugApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		System.out.println("Drug App");
		SpringApplication.run(DrugApp.class, args);
	}
}
