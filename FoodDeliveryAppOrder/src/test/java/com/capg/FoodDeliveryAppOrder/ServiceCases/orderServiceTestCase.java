package com.capg.FoodDeliveryAppOrder.ServiceCases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.FoodDeliveryAppOrder.entity.Customer;
import com.capg.FoodDeliveryAppOrder.entity.Order;
import com.capg.FoodDeliveryAppOrder.repository.copy.OrderRepository;
import com.capg.FoodDeliveryAppOrder.service.OrderService;

@SpringBootTest
public class orderServiceTestCase {
	@Autowired
	private OrderService orderservice;
	 @MockBean
	 private OrderRepository orderRepository;
	 private Order order ;
	 private Customer customer;
	 
	 
	 @BeforeEach
	 public void OrderServiceTestCaseSetup() {
		 order = new Order (1, 468.3,1);
	 }
	 @Test
	 public void placeOrderTest() {
		 Mockito.when(orderRepository.save(order)).thenReturn(order);
		 assertThat(orderservice.placeOrder(order)).isEqualTo(order);
		 
	 }
	 
	 @Test
	 public void cancelOrderTest() {
		 Mockito.doNothing().when(orderRepository).deleteById(order.getOrderId());
		 orderservice.cancelOrder(order.getOrderId());
		 verify(orderRepository, times(1)).deleteById(order.getOrderId());
		
	 }
	@Test
	public void viewOrderTest() throws Exception {
		Mockito.when(orderRepository.findById(1)).thenReturn(Optional.of(order));
		assertThat(orderservice.viewOrder(1)).isEqualTo(order);
	}
	@Test
	public void paymentOrderTest() {
		customer = new Customer(1L,"Dewas","Aj",98765443321L,"email","password","fail");
		assertThat(orderservice.paymentOrder(customer.getCustomerId())).isEqualTo("Payment Success");
	}

}
