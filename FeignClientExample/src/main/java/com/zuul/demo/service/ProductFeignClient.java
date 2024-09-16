package com.zuul.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zuul.demo.model.Product;

@FeignClient("ProductService")
public interface ProductFeignClient {

	@GetMapping(path = "/find/{name}")
	Product findProductByName(@PathVariable String name);
	
}
