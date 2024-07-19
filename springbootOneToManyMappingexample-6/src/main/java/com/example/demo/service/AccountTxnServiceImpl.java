package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountData;
import com.example.demo.repo.AccountTxnRepository;

@Service
public class AccountTxnServiceImpl implements AccountTxnService {


	@Autowired
	private AccountTxnRepository accountTxnRepository;
	
	@Override
	public int createAccount(AccountData accountData) {
		// TODO Auto-generated method stub
		//Random 8 digit Number Generated . but in Sequence.
		//Ex : SBIN/00000001
		
		 long count = accountTxnRepository.count();
		 
		 System.out.println("DB Count : " + count);
		 
		 if(count == 0) {
			 count += 1; 
		 }else if(count > 0) {
			  count ++;
		 }
		
		accountData.setAccountNumber("SBIN"+count);
		
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		String OpeningDate = dateFormat.format(date);
		
		accountData.setAccountOpeningDate(OpeningDate);
		accountData.setStatus(true);
		
		AccountData accountData2 = accountTxnRepository.save(accountData);
		
		return accountData2.getId();
	}

	@Override
	public AccountData getAccountData(int accnumber) {
		// TODO Auto-generated method stub
		
		String accNumber  = "SBIN"+accnumber;
		AccountData accountData = accountTxnRepository.findByAccountNumber(accNumber);
		return accountData;
	}
	
	
}
