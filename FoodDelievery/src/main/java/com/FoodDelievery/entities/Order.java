package com.FoodDelievery.entities;

import jakarta.persistence.Table;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
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
	private int orderId;
	private double price;
	private int quantity;
	
	

}
