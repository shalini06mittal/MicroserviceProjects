package com.techgatha.model;

import java.util.List;

public class BookOrderWrapper {

	private List<BookOrder> orders;
	private String memberType;
	
	
	public BookOrderWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public BookOrderWrapper(List<BookOrder> orders, String memberType) {
		super();
		this.orders = orders;
		this.memberType = memberType;
	}


	public List<BookOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<BookOrder> orders) {
		this.orders = orders;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}


	@Override
	public String toString() {
		return "BookOrderWrapper [orders=" + orders + ", memberType=" + memberType + "]";
	}
	
}

