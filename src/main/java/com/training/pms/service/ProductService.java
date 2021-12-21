package com.training.pms.service;

import java.util.List;

import com.training.pms.model.Product;

public interface ProductService {
	public List<Product> getProducts();
	public String saveProduct(Product product);
	public String updateProduct(Product product);
	public String deleteProduct(int productId);
	public Product getProduct(int productId);
	public boolean isProductExists(int productId);
	
	public List<Product> getProductByName(String productName);
	public List<Product> getProductByPrice(int price);
	public List<Product> getProductByPrice(int min,int max);
		
}
