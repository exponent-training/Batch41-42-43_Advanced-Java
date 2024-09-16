package com.zuul.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zuul.demo.model.Product;
import com.zuul.demo.service.HomeService;

@RestController
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping(value = "/product/{name}")
    public Product getProductUsingName(@PathVariable String name) {
		Product product = homeService.findProduct(name);
		return product;
	}
}
