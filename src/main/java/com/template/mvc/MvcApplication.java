package com.template.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

//scan for all the java classes
@ComponentScan("com.template.mvc.controllers")
@ComponentScan("com.template.mvc.repository")
@ComponentScan("com.template.mvc.models")
@ComponentScan("com.template.mvc.dataBaseServices")
@ComponentScan("com.template.mvc.services")

public class MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

}
