package com.techgatha.model;

import java.util.List;

public class BookOrderWrapper {

	private List<OrderWrapper> orders;
	private String memberType;
	public BookOrderWrapper(List<OrderWrapper> orders, String memberType) {
		super();
		this.orders = orders;
		this.memberType = memberType;
	}
	public List<OrderWrapper> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderWrapper> orders) {
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
