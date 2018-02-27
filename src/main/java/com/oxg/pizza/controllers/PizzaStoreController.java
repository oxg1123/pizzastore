package com.oxg.pizza.controllers;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.oxg.pizza.entities.Pizza;
import com.oxg.pizza.services.PizzaServiceImp;

@RestController
@RequestMapping("/pizzashop")
public class PizzaStoreController {

	@Autowired
	PizzaServiceImp service;
	
	@PostMapping("/createOrder")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String, Object> createOrder(@RequestBody Pizza pizza) {
		int ret = service.createOrder(pizza);
		HashMap<String, Object> map = new HashMap<>();
		map.put("OrderId", ret);
		return map;
	}
	
	@PutMapping("/addPizza/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public HashMap<String, Object> addPizza(@PathVariable("id") int orderId, @RequestBody Pizza pizza) {
		int lineItem;
		HashMap<String, Object> map = new HashMap<>();
		if (pizza.getName() != null) {
			lineItem = service.addMentLineItem(orderId, pizza);
			map.put("Id", lineItem);
		}
		return map;
	}

	@PutMapping("/addToppings/{id}/pizzaId={pizzaId}")
	public String addTopings(@PathVariable("id") int orderId, @PathVariable("pizzaId") int pizzaId, 
					@RequestParam("topping") String topping) {
		
		return "Success";
	}
	
	
	/*
	@GetMapping()
	@PutMapping()
	@PatchMapping()
	*/
}
