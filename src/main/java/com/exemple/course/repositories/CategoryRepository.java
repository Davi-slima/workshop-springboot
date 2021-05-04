package com.exemple.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	

}
