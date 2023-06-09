package com.FoodDelivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FoodDelievery.entities.Order;
import com.FoodDelievery.entities.User;
import com.FoodDelivery.exceptions.ResourcesNotFoundException;
import com.FoodDelivery.repository.OrderRepository;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
//		int randomOrderId = UUID.randomUUID().toString();
//		order.setOrderId(randomOrderId);

		return orderRepository.save(order);

	}

	@Override
	public void cancelOrder(int orderId){
		// TODO Auto-generated method stub
		  orderRepository.deleteById(orderId);
			
		
		
		

	}

	@Override
	public Order viewOrder(int orderId) throws ResourcesNotFoundException {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId)
				.orElseThrow(() -> new ResourcesNotFoundException("User Id is not found on server !! : " + orderId));

	}

	@Override
	public String paymentOrder(int customerId) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setPaymentStatus("Success");
		return "Payment Success";

	}

}
