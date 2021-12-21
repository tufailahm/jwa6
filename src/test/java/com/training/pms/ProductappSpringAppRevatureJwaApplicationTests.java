package com.training.pms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ProductappSpringAppRevatureJwaApplicationTests {

	@LocalServerPort
	private String port;
	
	private String baseURL = "http://localhost";
	
	URL url,messageURL;
	
	@Autowired
	RestTemplate restTemplate;
	
	@BeforeEach
	public void setUp() throws MalformedURLException
	{
		url = new URL(baseURL+ ":"+ port);
		messageURL = new URL(baseURL+ ":"+ port+"/message");
	}
	
	@Test
	@DisplayName("Testing home")
	public void contextLoads() {
				ResponseEntity<String> response = restTemplate.getForEntity(url.toString(), 
						String.class);
				assertEquals("Welcome to Revature JWA Training", response.getBody());
	}

	@Test
	@DisplayName("Testing Message")
	public void testMessage() {
				ResponseEntity<String> response = restTemplate.getForEntity(messageURL.toString(), 
						String.class);
				assertEquals("-- Revature Training App --", response.getBody());
	}
}
