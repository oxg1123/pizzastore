package com.oxg.pizza.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.oxg.pizza.entities.MenuItem;

public class Order {
	private Map<Integer,MenuItem> items = new HashMap<Integer,MenuItem>();

	private int orderNum = 0;
	private int orderItems = 0;
	
	public int crateOrder(MenuItem newItem) {
		if (newItem != null) {
			items.put(orderItems, newItem);
			orderNum =  new Random().nextInt(100);
		};
		return orderNum;
	}
	
	public void addItem(MenuItem newItem) {
		if (newItem != null) {
			orderItems++;
			items.put(orderItems, newItem);
		}
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
	
	
	
}
