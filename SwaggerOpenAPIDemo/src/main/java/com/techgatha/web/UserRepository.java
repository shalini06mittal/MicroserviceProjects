package com.techgatha.web;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techgatha.web.model.User;

public interface UserRepository extends JpaRepository<User	, String> {

}
