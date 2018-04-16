package com.efforttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class EffortTrackerApplication {

	@Autowired
	UserDao userDao;
	
	public static void main(String[] args) {
		SpringApplication.run(EffortTrackerApplication.class, args);
	}
	
	
}

