package com.uwindsor.receipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.uwindsor.receipe.controllers","com.uwindsor.receipe.BootStrap","com.uwindsor.receipe.Service"})
@SpringBootApplication
public class ReceipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceipeApplication.class, args);
	}

}
