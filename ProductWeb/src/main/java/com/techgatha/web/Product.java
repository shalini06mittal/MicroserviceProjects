package com.techgatha.web;

public class Product {

	private Integer pid;
	private String name;
	private String code;
	private String title;
	private String description;
	private double price;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(Integer pid, String name, String code, String title, String description, double price) {
		super();
		this.pid = pid;
		this.name = name;
		this.code = code;
		this.title = title;
		this.description = description;
		this.price = price;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", code=" + code + ", title=" + title + ", description="
				+ description + ", price=" + price + "]";
	}
	
	
}
