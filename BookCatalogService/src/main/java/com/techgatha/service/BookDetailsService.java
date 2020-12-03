package com.techgatha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.techgatha.model.BookCatalog;

@Service
public class BookDetailsService {

	@Autowired
	private BookFeignClient bookclient;
	
	@HystrixCommand(fallbackMethod = "getFallbackBookById",
	commandProperties = 
	@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000"))
	public BookCatalog getBookById(String bookid)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(bookid.equals("B1"))
//			throw new RuntimeException("Book unavailble");
		return this.bookclient.getBookDetails1(bookid);
	}
	public BookCatalog getFallbackBookById(String bookid)
	{
		return new BookCatalog("", "", 0, "");
	}
}
