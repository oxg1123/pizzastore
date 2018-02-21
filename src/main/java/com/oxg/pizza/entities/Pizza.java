package com.oxg.pizza.entities;

import com.oxg.pizza.entities.MenuItem;

public class Pizza extends MenuItem {
	private String[] topings = new String[10];
	private int idex = 0;
	
	public Pizza() {
		super();
	}
	
	public String[] getTopings() {
		return topings;
	}
	public void addTopings(String toping) {
		topings[idex] = toping;
		idex++;
	}

	public void removeTopings(String toping) {
		String[] temp = new String[10];
		int k = 0;
		for(int i=0; i < idex; i++,  k++) {
			if (topings[i].equals(toping)) {
				k--;
			} else
				temp[k] = topings[i];
				
		};
		topings = temp;
		idex = k;
	}

	public void printTopings() {
		System.out.println("List of toppings");
		for(int i= 0; i < idex; i++) {
			System.out.println("Toppings: " + topings[i]);
		};
	}
	
}
