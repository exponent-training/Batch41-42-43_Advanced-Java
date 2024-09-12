package com.product.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.demo.entity.Product;
import com.product.demo.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "/get")
	public ResponseEntity<List<Product>> getProductData() {
		List<Product> list = productService.fetchAllProducts();
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		productService.saveProduct(product);
		return new ResponseEntity<String>("Product Saved.",HttpStatus.OK);
	}

}
