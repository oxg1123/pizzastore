package com.oxg.pizza.services;

import com.oxg.pizza.entities.MenuItem;

public interface OrderService {
	public int createOrder(MenuItem item);
	public int addMentLineItem(int orderId, MenuItem item);
	public void removeMenuLineItem();
}
