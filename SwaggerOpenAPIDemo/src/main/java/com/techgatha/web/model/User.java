package com.techgatha.web.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

@Entity
@Schema(description = "User model and descritpion ")
@Tag(name = "User API", description = "A secured API")
public class User {

	@Id
	@NotNull
	@Schema(name="userid", description = "It is String in format :U1")
	private String userid;
	@NotBlank
	@Size(min=5, max=20)
	private String username;
	@Pattern(regexp = "\\s+")
	private String email;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String userId, String username, String email) {
		super();
		this.userid = userId;
		this.username = username;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [userId=" + userid + ", username=" + username + ", email=" + email + "]";
	}
	
}
