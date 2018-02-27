package com.oxg.pizza;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.oxg.pizza.entities.Order;
import com.oxg.pizza.entities.Pizza;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaStoreEntitiesTests {

   @Autowired
   private Order order;
   
   
   @Before
   public void setup() {
   }
   
 
	private Pizza createPizza(String name, String descritpion) {
		Pizza newItem = new Pizza();
		newItem.setName(name);
		newItem.setDescription(descritpion);
		return newItem;
	}
	
	
	@Test
	public void testOrderCreationTrue() {
		int orderNumber = order.crateOrder(createPizza("Cheese pizza", "pizza"));
		assertTrue(orderNumber > 0);
	}
	
	@Test
	public void testOrderCreationFalse() {
		int orderNumber = order.crateOrder(null);
		assertTrue(orderNumber == 0);
	}
	
	@Test
	public void testOrderAdditionalPizza() {
		order.crateOrder(createPizza("Cheese pizza 1", "pizza"));
		order.addItem(createPizza("Cheese pizza 2", "pizza"));
		order.addItem(createPizza("Cheese pizza 3", "pizza"));
		order.addItem(createPizza("Cheese pizza 4", "pizza"));
		order.removeItem(2);
		assertTrue(order.getOrderItems() == 3);
	}
	
	@Test
	public void testOrderAdditionalPizzaToppings() {
		order.crateOrder(createPizza("Cheese pizza 1", "pizza"));
		order.addItem(createPizza("Cheese pizza 2", "pizza"));
		order.addItem(createPizza("Cheese pizza 3", "pizza"));
		order.dumpData();
		
		Pizza pizza = (Pizza) order.getLineItem(order.getLineItem("Cheese pizza 2"));
		pizza.addTopings("Cheese");
		pizza.addTopings("Tomatoes");
		pizza.removeTopings("Cheese");
		pizza.addTopings("Peppers");
		assertTrue(pizza.getNumberOfToppings() == 2);
	}
	
	
}
