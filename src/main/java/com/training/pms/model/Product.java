package com.training.pms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jwaproducts")
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private int quantityOnHand;
	private int price;
	
	
}
