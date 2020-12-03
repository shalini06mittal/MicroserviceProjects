package com.techgatha.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UIController {

	@Autowired
	RestTemplate template;
	
	String url="http://zuul-gateway/api/products";
	@RequestMapping("/products")
	public List<Product> getAllProducts()
	{
		System.out.println("get products");
		Product products[] = template.getForObject(url, Product[].class);
		return Arrays.asList(products);
	}
	@RequestMapping("/books")
	public String getAllBooks()
	{
		System.out.println("get books");
		System.out.println(template.getForObject("http://zuul-gateway/bapi/books", String.class));
		return template.getForObject("http://zuul-gateway/bapi/books", String.class);
		
	}
}
