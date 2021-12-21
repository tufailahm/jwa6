package com.training.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.pms.model.Product;
import com.training.pms.service.ProductService;

@RestController
@RequestMapping("product") // localhost:9090/product
public class ProductController {

	@Autowired
	ProductService productService;

	// SRP
	@PostMapping
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		ResponseEntity<String> responseEntity = null;
		String message = null;
		System.out.println("Product data to be saved" + product);
		// code to save
		if (productService.isProductExists(product.getProductId())) {
			message = "Product with product id : " + product.getProductId() + " already exists";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.CONFLICT);
		} else {
			message = productService.saveProduct(product);
			responseEntity = new ResponseEntity<String>(message, HttpStatus.CREATED);
		}

		return responseEntity;
	}

	// to get all product
	@GetMapping
	public ResponseEntity<List<Product>> getProducts() {
		ResponseEntity<List<Product>> responseEntity = null;

		System.out.println("Fetching all the records");
		// code to fetch all products
		List<Product> products = productService.getProducts();
		if (products.size() == 0) {
			responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.NO_CONTENT);
		} else {
			responseEntity = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}

		return responseEntity;
	}

	// to update a product
	@PutMapping
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		System.out.println("Product data to be updated" + product);
		ResponseEntity<String> responseEntity = null;
		String message = null;
		// code to save
		if (productService.isProductExists(product.getProductId())) {
			message = productService.updateProduct(product);
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);

		} else {
			message = "Product with product id : " + product.getProductId() + " already exists";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NOT_MODIFIED);
		}

		return responseEntity;
	}

	// to get a single product
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		System.out.println("Product data to be fetched" + productId);
		ResponseEntity<Product> responseEntity = null;
		String message = null;
		Product product = new Product();
		// code to save
		if (productService.isProductExists(productId)) {
			product = productService.getProduct(productId);
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK);

		} else {
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);

		}

		return responseEntity;
	}

	// to delete a single product
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		System.out.println("Product data to be deleted" + productId);
		ResponseEntity<String> responseEntity = null;
		String message = null;
		// code to save
		if (productService.isProductExists(productId)) {
			message = productService.deleteProduct(productId);
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);

		} else {
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);

		}

		return responseEntity;
	}

	// to get all the products using productName
	@GetMapping("/getProductByName/{productName}") // localhost:9090/product/getProductByName/Pendrive
	public String getProductByName(@PathVariable("productName") String productName) {
		System.out.println("Product get to be using product name" + productName);
		// code to get a single product using product id
		return "Product fetched successfully " + productName;
	}

	// Hands-on
	// localhost:9090/product/getProductByPrice/78000/to/94000
	// localhost:9090/product/getProductByPrice/18000/to/20000
	// Getting product in the range of 18000 and 20000

	@GetMapping("getProductByPrice/{minPrice}/to/{maxPrice}")
	public String getProductByPrice(@PathVariable("minPrice") int minPrice, @PathVariable("maxPrice") int maxPrice) {
		System.out.println("Product price range = " + minPrice + " to " + maxPrice);
		// code to retrieve
		return "Getting product in the range of " + minPrice + " and " + maxPrice;
	}

}
