package com.cookCycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class CookCycleApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CookCycleApplication.class, args);
	}
}
