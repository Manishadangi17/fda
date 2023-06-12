package com.capg.FoodDeliveryAppOrder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.FoodDeliveryAppOrder.entity.Order;
import com.capg.FoodDeliveryAppOrder.service.OrderService;

@RestController
@RequestMapping("/v3/api-docs/Order")

public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeOrder")
	public Order placeOrder(@RequestBody Order order) {
		return orderService.placeOrder(order);
		
	}
	
	@DeleteMapping("/cancelOrder/{orderId}")
	public void cancelOrder(@PathVariable int orderId) {
		orderService.cancelOrder(orderId);
		
	}
	@GetMapping("/viewOrder/{orderId}")
	public Order viewOrder(@PathVariable int orderId) throws Exception{
		return orderService.viewOrder(orderId);
	}
	
	@PutMapping("/paymentOrder/{customerId}")
	public String paymentOrder(@PathVariable long customerId) {
		return orderService.paymentOrder(customerId);
		
	}
}
