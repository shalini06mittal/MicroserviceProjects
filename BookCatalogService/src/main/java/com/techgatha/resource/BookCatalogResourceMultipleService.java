package com.techgatha.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techgatha.model.BookCatalog;
import com.techgatha.model.BookOrderWrapper;
import com.techgatha.model.BookUserCatalog;
import com.techgatha.model.OrderWrapper;
import com.techgatha.model.UserCatalog;
import com.techgatha.service.BookCatalogService;
import com.techgatha.service.BookDetailsService;
import com.techgatha.service.BookOrderDetailsService;

@RestController
@RequestMapping("/catalogms")
public class BookCatalogResourceMultipleService {

	@Autowired
	private BookOrderDetailsService service;
	
	@Autowired
	private BookDetailsService bookDetailsServcie;
	
	@GetMapping("/wrapper/{email}")
	public BookUserCatalog getBooksPurchasedWrapper(@PathVariable String email)
	{
		
		BookUserCatalog bookUserCatalog = new BookUserCatalog();
		BookOrderWrapper bookOrderWrapper = this.service.getBooksOrderedFromWrapper(email);
		List<OrderWrapper> orders = bookOrderWrapper.getOrders();
		String memberType =  bookOrderWrapper.getMemberType();
	
		if(orders!=null && orders.size() >0) {
			List<BookCatalog> bookcatalog = orders.stream()
			.map(wrapper ->{
				System.out.println(wrapper.getBookid());
				BookCatalog catalog = this.bookDetailsServcie.getBookById(wrapper.getBookid());
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

	
}
