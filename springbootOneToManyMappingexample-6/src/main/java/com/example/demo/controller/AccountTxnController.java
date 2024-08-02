package com.example.demo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

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


	@RequestMapping(value = "/generateCSV")
	public void generateCSVFile(HttpServletResponse response) throws IOException {
		List<AccountData> list =  accountTxnService.generatecsvFileData();


		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String txtDate = dateFormat.format(date);

		response.setContentType("text/csv");

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=accountData_"+txtDate+".csv";

		response.setHeader(headerKey, headerValue);

		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvName = {"ID","ACCOUNTNUMBER","ACCOUNTTYPE","IFSCCODE","BRANCHNAME","ACCOUNTHOLDERNAME","TOTALBALANCE"};

		String[] csvMapping = {"id","accountNumber","accountType","ifscCode","bankbranch","accountHolderName","totalBalance"};

		csvWriter.writeHeader(csvName);

		for(AccountData accountData : list) {
			csvWriter.write(accountData, csvMapping);
		}

		csvWriter.close();
	}







}
