package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Covid19VaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(Covid19VaccinationApplication.class, args);
		
		System.out.println("covid vaccination started");
	}

}