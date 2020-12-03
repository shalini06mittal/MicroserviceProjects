package com.eduramp.server.EurekaServerERDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerErDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerErDemoApplication.class, args);
	}

}
