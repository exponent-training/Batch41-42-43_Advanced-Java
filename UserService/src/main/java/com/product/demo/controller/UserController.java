package com.product.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.model.Product;
import com.product.demo.service.UserServiceI;

@RestController
public class UserController {

	
	@Autowired
	private UserServiceI userServiceI;
	
	@GetMapping(value = "/findProduct/{name}")
	public ResponseEntity<Product> getProductData(@PathVariable String name){
		System.out.println("Check Product Name");
		Product product = userServiceI.getProduct(name);
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
}
