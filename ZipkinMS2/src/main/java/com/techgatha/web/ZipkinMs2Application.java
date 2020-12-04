package com.techgatha.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(ZipkinMs2Application.class, args);
	}

	@Autowired
	RestTemplate template;
	
	@Bean
	public RestTemplate template()
	{
		return new RestTemplate();
	}
	Logger log = LoggerFactory.getLogger(ZipkinMs2Application.class);
	@RequestMapping("/ms2")
	public String ms1()
	{
		
		log.info("MS2 => req to MS3");
		return template.getForObject("http://localhost:8083/ms3", String.class);
	}
}
//2f8ca77942ae9367,2f8ca77942ae9367