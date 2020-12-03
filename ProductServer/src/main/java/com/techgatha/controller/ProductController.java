package com.techgatha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.model.Product;
import com.techgatha.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository repository;
	
	@GetMapping("/products")
	public List<Product> getAllProducts()
	{
		return repository.findAll();
	}
	@GetMapping("/products/{pid}")
	public Product getProductById(@PathVariable Integer pid)
	{
		return repository.findById(pid).get();
	}
	
}
