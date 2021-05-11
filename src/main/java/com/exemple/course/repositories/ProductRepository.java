package com.exemple.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	

}
