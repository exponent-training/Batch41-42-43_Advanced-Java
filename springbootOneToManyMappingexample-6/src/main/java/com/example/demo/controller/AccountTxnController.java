package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AccountData;
import com.example.demo.entity.TransactionData;
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
	
	@GetMapping(value = "/getAccountData/{accno}")
    public ResponseEntity<AccountData> getAccountDetailsUsingAccId(@PathVariable("accno") int accnumber){
		System.out.println("Check Account Number : " + accnumber);
		AccountData accountData = accountTxnService.getAccountData(accnumber);
		return new ResponseEntity<AccountData>(accountData,HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/txtDetails/{accno}")
	public ResponseEntity<String> addTXTData(@RequestBody TransactionData txtData, @PathVariable int accno){
		System.out.println("Check Acc number And Transaction Data : " + accno + " " + txtData);
	    accountTxnService.addTXTData(txtData, accno);
	    return new ResponseEntity<String>("Operation Done.",HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/mailSendAttachment")
	public ResponseEntity<String> sendAttachment(){
		 accountTxnService.sendMailAttachment();
	    return new ResponseEntity<String>("Mail Send Done.",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	

}
