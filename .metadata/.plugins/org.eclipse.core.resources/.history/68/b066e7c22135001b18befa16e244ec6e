package com.techgatha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.techgatha.model.BookCatalog;
import com.techgatha.model.BookOrderWrapper;
import com.techgatha.model.BookUserCatalog;
import com.techgatha.model.OrderWrapper;
import com.techgatha.model.UserCatalog;

@Service
public class BookCatalogService {

	@Autowired
	RestTemplate template;
	
	@Autowired
	BookOrderFeignClient bookOrderFeignClient;
	
	@Autowired
	BookFeignClient bookFeignClient;
	
	public List<UserCatalog> getBooksOrdered(String email)
	{	
		System.out.println("********************");
		System.out.println(template.getForEntity("http://techgatha.com/movies.php",String.class));
		System.out.println("********************");
		List<OrderWrapper> orders = this.bookOrderFeignClient.getBookOrderDetails(email);
		
		return orders.stream()
		.map(wrapper ->{
			System.out.println(wrapper.getBookid());
			UserCatalog catalog = this.bookFeignClient.getBookDetails(wrapper.getBookid());
			catalog.setEmail(email);
			catalog.setDatetime(wrapper.getDatetime());
			return catalog;
		}).collect(Collectors.toList());
	}
	@HystrixCommand(fallbackMethod ="getFallbackBooksOrderedFromWrapper" )
	public BookUserCatalog getBooksOrderedFromWrapper(String email)
	{	
		
		BookUserCatalog bookUserCatalog = new BookUserCatalog();
		
		BookOrderWrapper bookOrderWrapper = this.bookOrderFeignClient.getBookOrderDetailsWrapper(email);
		List<OrderWrapper> orders = bookOrderWrapper.getOrders();
		String memberType =  bookOrderWrapper.getMemberType();
	
		if(orders!=null && orders.size() >0) {
			List<BookCatalog> bookcatalog = orders.stream()
			.map(wrapper ->{
				System.out.println(wrapper.getBookid());
				BookCatalog catalog = this.bookFeignClient.getBookDetails1(wrapper.getBookid());
				catalog.setDatetime(wrapper.getDatetime());
				return catalog;
			}).collect(Collectors.toList());
		 	bookUserCatalog.setCatalog(bookcatalog);
		}
		else bookUserCatalog.setCatalog(new ArrayList<BookCatalog>());
	 	bookUserCatalog.setEmail(email);
	 	bookUserCatalog.setMemberType(memberType);
	 	return bookUserCatalog;
	}
	public BookUserCatalog getFallbackBooksOrderedFromWrapper(String email)
	{	
			BookUserCatalog catalog = new BookUserCatalog();
			catalog.setCatalog(new ArrayList<BookCatalog>());
			catalog.setEmail(email);
			catalog.setMemberType("");
			return catalog;
	}
}
