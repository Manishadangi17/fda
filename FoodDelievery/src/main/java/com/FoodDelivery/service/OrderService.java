package com.FoodDelivery.service;

import com.FoodDelievery.entities.Order;

public interface OrderService {
	public Order placeOrder(Order order);
	public void cancelOrder(int orderId);
	public Order viewOrder(int orderId) throws Exception;
	public String paymentOrder(int customerId);

}
