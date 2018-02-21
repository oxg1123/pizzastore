package com.oxg.pizza.entities;

import java.util.Arrays;

import com.oxg.pizza.entities.MenuItem;

public class Pizza extends MenuItem {
	private String[] toppings = new String[10];
	private int idex = 0;
	
	public Pizza() {
		super();
	}
	
	public String[] getTopings() {
		return toppings;
	}
	public void addTopings(String toping) {
		toppings[idex] = toping;
		idex++;
	}

	public void removeTopings(String toping) {
		String[] temp = new String[10];
		int k = 0;
		for(int i=0; i < idex; i++,  k++) {
			if (toppings[i].equals(toping)) {
				k--;
			} else
				temp[k] = toppings[i];
				
		};
		toppings = temp;
		idex = k;
	}

	public int getNumberOfToppings() {
		return idex;
	}
	
	public void printTopings() {
		System.out.println("List of toppings");
		for(int i= 0; i < idex; i++) {
			System.out.println("Toppings: " + toppings[i]);
		};
	}

}
