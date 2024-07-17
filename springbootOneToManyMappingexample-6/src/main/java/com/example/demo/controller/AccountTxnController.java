package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccountData;
import com.example.demo.service.AccountTxnService;

@RestController
public class AccountTxnController {
	
	
	@Autowired
	private AccountTxnService accountTxnService;
	
	@PostMapping(value = "/accountCreate")
	public ResponseEntity<String> createAccoount(@RequestBody AccountData accountData){
		System.out.println("Check Account Data : " + accountData);
		int i = accountTxnService.createAccount(accountData);
		if(i>0) {
			return new ResponseEntity<String>("Account Created",HttpStatus.CREATED);
		}
		else{
			return new ResponseEntity<String>("Account Not Created",HttpStatus.OK);
		}
	}

}
