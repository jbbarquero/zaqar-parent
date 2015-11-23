package com.malsolo.zaqar.event.receiver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZaqarEventReceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZaqarEventReceiverApplication.class, args);
    }
}
