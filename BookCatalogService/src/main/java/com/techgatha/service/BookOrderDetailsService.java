package com.techgatha.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.techgatha.model.BookCatalog;
import com.techgatha.model.BookOrderWrapper;
import com.techgatha.model.BookUserCatalog;
import com.techgatha.model.OrderWrapper;

@Service
public class BookOrderDetailsService {

	@Autowired
	private BookOrderFeignClient bookOrderFeignClient;
	
	@HystrixCommand(fallbackMethod ="getFallbackBooksOrderedFromWrapper" )
	public BookOrderWrapper getBooksOrderedFromWrapper(String email)
	{	
		BookOrderWrapper bookOrderWrapper = this.bookOrderFeignClient.getBookOrderDetailsWrapper(email);
	
	 	return bookOrderWrapper;
	}
	public BookOrderWrapper getFallbackBooksOrderedFromWrapper(String email)
	{	
			BookOrderWrapper wrapper = new BookOrderWrapper(new ArrayList<OrderWrapper>(), "NOT AVAILABLE");
			return wrapper;
	}
	
}
