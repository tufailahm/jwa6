package com.training.pms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.training.pms.model.Product;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductappSpringAppRevatureJwaApplicationTestsProduct {

	@LocalServerPort
	private String port;
	
	private String baseURL = "http://localhost";
	
	URL url,deleteURL;
	
	@Autowired
	RestTemplate restTemplate;
	
	int productId=0;
	
	@BeforeEach
	public void setUp() throws MalformedURLException
	{
		url = new URL(baseURL+ ":"+ port+"/product");
		productId = 78265;
	}
	
	@Test
	@DisplayName("Testing save Product - CREATED")
	public void testSave() {
		Product product = new Product(productId, "Dummy", 99 , 999);
		
				ResponseEntity<String> response = restTemplate.postForEntity(url.toString(),product,String.class); 
						
				System.out.println("Testing response :"+response);
				assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
				
	}

	/*
	 * @Test
	 * 
	 * @DisplayName("Testing get Products -  No Content") public void getProducts2()
	 * {
	 * 
	 * ResponseEntity<List> response = restTemplate.getForEntity(url.toString(),
	 * List.class); System.out.println("Testing response :"+response);
	 * assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); }
	 * 
	 * @Test
	 * 
	 * @DisplayName("Testing Delete Products -  No Content") public void
	 * testDelete() {
	 * 
	 * restTemplate.delete(deleteUrl.toString(), String.class);
	 * System.out.println("Testing response :"+response);
	 * assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); }
	 */
}
