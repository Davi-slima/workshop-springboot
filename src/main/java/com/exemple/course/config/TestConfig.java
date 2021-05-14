package com.exemple.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.exemple.course.entities.Category;
import com.exemple.course.entities.Order;
import com.exemple.course.entities.OrderItem;
import com.exemple.course.entities.Payment;
import com.exemple.course.entities.Product;
import com.exemple.course.entities.User;
import com.exemple.course.entities.enums.OrderStatus;
import com.exemple.course.repositories.CategoryRepository;
import com.exemple.course.repositories.OrderItemRepository;
import com.exemple.course.repositories.OrderRepository;
import com.exemple.course.repositories.ProductRepository;
import com.exemple.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category categoria1 = new Category(null, "Eletronics");
		Category categoria2 = new Category(null, "Books");
		Category categoria3 = new Category(null, "Computers");
		
		Product produto1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.50, "");
		Product produto2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Macenas ante.", 2190.00, "");
		Product produto3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.00, "");
		Product produto4 = new Product(null, "Pc Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.00, "");
		Product produto5 = new Product(null, "Rails for Dummies", "Cras frigilla covallis sem vel faucibus", 100.99, "");
		
		categoryRepository.saveAll(Arrays.asList(categoria1, categoria2, categoria3));
		productRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		produto1.getCategories().add(categoria2);
		produto2.getCategories().add(categoria1);
		produto2.getCategories().add(categoria3);
		produto3.getCategories().add(categoria3);
		produto4.getCategories().add(categoria3);
		produto5.getCategories().add(categoria2);
		
		productRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4, produto5));
		
		User usuario1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User usuario2 = new User(null, "Cleiton Rasta", "cleitin@gmail.com", "977777777", "123456");

		Order pedido1 = new Order(null, Instant.parse("2021-03-02T21:18:07Z"),OrderStatus.PAID, usuario1);
		Order pedido2 = new Order(null, Instant.parse("2021-04-03T03:30:10Z"), OrderStatus.WAITING_PAYMENT, usuario2);
		Order pedido3 = new Order(null, Instant.parse("2021-04-04T21:53:22Z"), OrderStatus.WAITING_PAYMENT, usuario1);
		
		userRepository.saveAll(Arrays.asList(usuario1, usuario2));
		orderRepository.saveAll(Arrays.asList(pedido1, pedido2, pedido3));
		
		OrderItem oi1 = new OrderItem(pedido1, produto1, 2, produto1.getPrice());
		OrderItem oi2 = new OrderItem(pedido1, produto3, 1, produto3.getPrice());
		OrderItem oi3 = new OrderItem(pedido2, produto3, 2, produto3.getPrice());
		OrderItem oi4 = new OrderItem(pedido3, produto5, 2, produto5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pagamento1 = new Payment(null, Instant.parse("2021-03-02T23:18:07Z"), pedido1);
		pedido1.setPayment(pagamento1); // ASSOCIAÇÃO DO PEDIDO 1 COM O PAGAMENTO1 
		
		orderRepository.save(pedido1);
		
	}
}
