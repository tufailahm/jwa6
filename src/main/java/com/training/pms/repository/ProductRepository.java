package com.training.pms.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.pms.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
}
