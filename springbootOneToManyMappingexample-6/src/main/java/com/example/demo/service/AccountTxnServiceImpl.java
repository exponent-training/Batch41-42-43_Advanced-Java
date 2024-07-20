package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AccountData;
import com.example.demo.repo.AccountTxnRepository;

@Service
public class AccountTxnServiceImpl implements AccountTxnService {


	@Autowired
	private AccountTxnRepository accountTxnRepository;
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
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
		
		if(accountData2 != null) {
			
			SimpleMailMessage message = new SimpleMailMessage();
			
			message.setTo("pramodkhandare0050@gmail.com","andhalekrushna101@gmail.com");
			
			message.setSubject("Thanks For Creating Account.");
			
			message.setText("Hi Team,  Thank you for Getting Our Service. Your Account Succeassfully Created.");
		
			
			javaMailSender.send(message);
			
		}
		
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
