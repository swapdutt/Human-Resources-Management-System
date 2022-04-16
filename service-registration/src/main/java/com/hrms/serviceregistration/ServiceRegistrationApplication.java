package com.hrms.serviceregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistrationApplication.class, args);
    }
}
