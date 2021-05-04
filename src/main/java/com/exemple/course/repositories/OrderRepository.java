package com.exemple.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}
