package com.training.pms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping			//localhost:9090
	public String home() {
		return "Welcome to Revature JWA Training";
	}
	
	@GetMapping("message")		//localhost:9090/message
	public String message() {
		return "-- Revature Training App --";
	}
}
