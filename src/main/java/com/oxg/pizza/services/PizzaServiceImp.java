package com.oxg.pizza.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.oxg.pizza.entities.MenuItem;
import com.oxg.pizza.entities.Order;

@Service
public class PizzaServiceImp implements OrderService {

	@Autowired
	private WebApplicationContext applicationContext;
	
	 private Map<Integer, Order> orders = new HashMap<>();

	
	@Override
	public int createOrder(MenuItem item) {
		Order order = applicationContext.getBean(Order.class);
		int orderNumber =  order.crateOrder(item);
		orders.put(orderNumber, order);
		return orderNumber;
	}

	@Override
	public int addMentLineItem(int orderId, com.oxg.pizza.entities.MenuItem item) {
		Order order = orders.get(orderId);
		return order.addItem(item);
	}

	@Override
	public void removeMenuLineItem() {
		// TODO Auto-generated method stub
		
	}

}
