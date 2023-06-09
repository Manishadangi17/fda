package com.FoodDelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodDelievery.entities.Order;
import com.FoodDelivery.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> createOrder(@RequestBody Order order){
		
		Order order1 = orderService.placeOrder(order);
		return ResponseEntity.status(HttpStatus.CREATED).body(order1);
		
	}
	
	@GetMapping("/{OrderId}")
	public ResponseEntity<Order> getOrder( @PathVariable int orderId) throws Exception{
		Order order = orderService.viewOrder(orderId);
		return ResponseEntity.ok(order);
		
	}

}
