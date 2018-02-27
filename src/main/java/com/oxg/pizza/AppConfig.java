package com.oxg.pizza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.oxg.pizza.entities.Order;
import com.oxg.pizza.entities.Pizza;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public Order order() {
		return new Order();
	}
	
	
	@Bean
	@Scope("prototype")
	public Pizza pizza() {
		return new Pizza();
	}
}
