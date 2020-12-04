package com.techgatha.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinMs3Application {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinMs3Application.class, args);
	}

	Logger log = LoggerFactory.getLogger(ZipkinMs3Application.class);
	@RequestMapping("/ms3")
	public String ms1()
	{
		
		log.info("MS3 => req back to MS2");
		return "Microservice 3 sent the response back";
	}
}
