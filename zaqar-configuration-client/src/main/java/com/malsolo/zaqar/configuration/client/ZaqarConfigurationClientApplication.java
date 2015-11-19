package com.malsolo.zaqar.configuration.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

//To update changes use curl -d{} http://localhost:8081/refresh
@SpringBootApplication
public class ZaqarConfigurationClientApplication {

	@Autowired
	void setEnvironment(Environment e) {
		System.out.println(e.getProperty("configuration.projectName"));
	}

	public static void main(String[] args) {
		SpringApplication.run(ZaqarConfigurationClientApplication.class, args);
	}
}
