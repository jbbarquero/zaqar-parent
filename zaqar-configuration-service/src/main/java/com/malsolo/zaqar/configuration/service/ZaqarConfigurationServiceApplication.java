package com.malsolo.zaqar.configuration.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

// Run and go to http://localhost:8888/zaqar-configuration-client/master
@SpringBootApplication
@EnableConfigServer
public class ZaqarConfigurationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZaqarConfigurationServiceApplication.class, args);
    }
}
