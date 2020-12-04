package com.techgatha.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController

public class ZipkinMs1Application {

	
	
	public static void main(String[] args) {
		SpringApplication.run(ZipkinMs1Application.class, args);
	}

	@Autowired
	RestTemplate template;
	
	@Bean
	public RestTemplate template()
	{
		return new RestTemplate();
	}
	Logger log = LoggerFactory.getLogger(ZipkinMs1Application.class);
	@RequestMapping("/ms1")
	public String ms1()
	{
		
		log.info("MS1 => req to MS2");
		return template.getForObject("http://localhost:8082/ms2", String.class);
	}
}
