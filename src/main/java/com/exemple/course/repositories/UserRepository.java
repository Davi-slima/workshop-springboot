package com.exemple.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	

}
