package com.exemple.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exemple.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	

}
