package com.capg.FoodDeliveryAppOrder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Order {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	private int orderId;
	private double price;
	private int quantity;

}
