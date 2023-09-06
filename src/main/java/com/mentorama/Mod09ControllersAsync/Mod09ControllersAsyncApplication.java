package com.mentorama.Mod09ControllersAsync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
//@ComponentScan(basePackages = {"com.mentorama.Mod09ControllersAsync"})
public class Mod09ControllersAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mod09ControllersAsyncApplication.class, args);
	}

}
