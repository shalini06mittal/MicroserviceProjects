package com.techgatha.model;

import java.util.List;

public class BookUserCatalog {

	private List<BookCatalog> catalog;
	private String email;
	private String memberType;
	public BookUserCatalog() {
		// TODO Auto-generated constructor stub
	}
	public List<BookCatalog> getCatalog() {
		return catalog;
	}
	public void setCatalog(List<BookCatalog> catalog) {
		this.catalog = catalog;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	@Override
	public String toString() {
		return "BookUserCatalog [catalog=" + catalog + ", email=" + email + ", memberType=" + memberType + "]";
	}
	
}
