package com.product.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@GetMapping(value = "/get")
	public String getAppData() {
		return "Product Controller Called.";
	}

}
