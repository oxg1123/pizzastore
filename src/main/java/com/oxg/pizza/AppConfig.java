package com.oxg.pizza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.oxg.pizza.entities.MenuItem;
import com.oxg.pizza.entities.Order;
import com.oxg.pizza.entities.Pizza;

@Configuration
public class AppConfig {

	@Bean
	public Order order() {
		return new Order();
	}
	
	@Bean
	public MenuItem menuItem() {
		return new MenuItem();
	}
	
	@Bean
	public Pizza pizza() {
		return new Pizza();
	}
}
