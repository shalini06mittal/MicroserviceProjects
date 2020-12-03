package com.techgatha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.techgatha.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
