package com.exemple.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exemple.course.entities.Order;
import com.exemple.course.entities.User;
import com.exemple.course.entities.enums.OrderStatus;
import com.exemple.course.repositories.OrderRepository;
import com.exemple.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User user2 = new User(null, "Cleiton Rasta", "cleitin@gmail.com", "977777777", "123456");

		Order order1 = new Order(null, Instant.parse("2021-03-02T21:18:07Z"),OrderStatus.PAID, user1);
		Order order2 = new Order(null, Instant.parse("2021-04-03T03:30:10Z"), OrderStatus.WAITING_PAYMENT,user2);
		Order order3 = new Order(null, Instant.parse("2021-04-04T21:53:22Z"), OrderStatus.WAITING_PAYMENT,user1);
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		orderRepository.saveAll(Arrays.asList(order1, order2, order3));
		
	}
	
	
}
