package com.sunny;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CarhateoasApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CarhateoasApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
/*
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	*/

}
