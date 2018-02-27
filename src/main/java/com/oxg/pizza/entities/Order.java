package com.oxg.pizza.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.oxg.pizza.entities.MenuItem;

public class Order {
	private Map<Integer,MenuItem> items = new HashMap<Integer,MenuItem>();
	private int orderNum = 0;
	private int orderItems = 0;
	
	public Order() {
		super();
	}

	public int crateOrder(MenuItem newItem) {
		if (newItem != null) {
			orderNum =  new Random().nextInt(100);
			addItem(newItem);
		};
		return orderNum;
	}
	
	public int addItem(MenuItem newItem) {
		if (newItem != null) {
			items.put(orderItems, newItem);
			orderItems++;
			return orderItems;
		} else
			return 0;
	}
	
	public MenuItem getLineItem(int lineItem) {
		return items.get(lineItem);
	}

	public int getLineItem(String name) {
		int key = 0;
		for (int i=0; i < items.size(); i++) {
			if (items.get(i).getName().equals(name)) {
				key = i;
				break;
			}
				
		}
		return key;
	}

	public void removeItem(int lineItem) {
		items.remove(lineItem);
		orderItems --;
	}

	public int getOrderItems() {
		return orderItems + 1;
	}
	
	public void dumpData() {
		System.out.println("Order orderNum= [" + orderNum + " ]");
		for(MenuItem item: items.values()) {
			System.out.println("item.name: " + item.getName());
			System.out.println("item.desc: " + item.getDescription());
		}
	}

	@Override
	public String toString() {
		return "Order [items=" + items + ", orderNum=" + orderNum + "]";
	}
	
	public void clear() {
		items.clear();
		orderNum = 0;
		orderItems = 0;
	}
	
	
	
}
