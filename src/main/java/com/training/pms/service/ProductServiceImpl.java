package com.training.pms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.pms.model.Product;
import com.training.pms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}
	@Override
	public String saveProduct(Product product) {
		if(product.getPrice() <0 || product.getQuantityOnHand() < 0)
		{
			return "Product not saved successfully (Reason - Price or QOH is negative )";

		}
		else {
			productRepository.save(product);
			return "Product saved successfully";
		}
	}
	@Override
	public String updateProduct(Product product) {
		 productRepository.save(product);
		return "Product updated successfully";
	}
	@Override
	public String deleteProduct(int productId) {
		 productRepository.deleteById(productId);
		return "Product deleted successfully";

	}
	@Override
	public Product getProduct(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.get();
	}	
	
	@Override
	public boolean isProductExists(int productId) {
		Optional<Product> product = productRepository.findById(productId);
		return product.isPresent();
	}

	
	
	@Override
	public List<Product> getProductByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductByPrice(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

}
