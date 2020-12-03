package com.techgatha;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techgatha.model.Product;
import com.techgatha.repository.ProductRepository;

@Component
public class InitializationComponent {

	@Autowired
	private ProductRepository repository;
	
	@PostConstruct
	public void init()
	{
		System.out.println("init");
		//repository.deleteAll();
		Product p1 = new Product();
		p1.setCode("SAM-TRIOS");
		p1.setDescription("Samsung Trios 12 Touch");
		p1.setName("Samsung D3");
		p1.setPrice(1200.00);
		p1.setTitle("Samsung 12 inch");
		repository.save(p1);
		
		p1 = new Product();
		p1.setCode("LOKIA-PONIA");
		p1.setDescription("Lokia Ponia 18");
		p1.setName("Lokia Ponia");
		p1.setPrice(1000);
		p1.setTitle("Lokia 15 inch");
		repository.save(p1);
		
		 p1 = new Product();
		p1.setCode("HUWEI-Sp");
		p1.setDescription("Huwei Watch for perfect use");
		p1.setName("HUWEI SpyWatch");
		p1.setPrice(800);
		p1.setTitle("Huwei 4 inch watch");
		repository.save(p1);
		
		
	}
}
