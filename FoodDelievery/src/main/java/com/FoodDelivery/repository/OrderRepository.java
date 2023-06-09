package com.FoodDelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodDelievery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
