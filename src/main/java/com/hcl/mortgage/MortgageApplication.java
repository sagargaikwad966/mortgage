package com.hcl.mortgage;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hcl.mortgage.utility.UserUtils;

@SpringBootApplication
public class MortgageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageApplication.class, args);
	}

}
