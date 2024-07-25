package com.example.demo.service;

import com.example.demo.entity.AccountData;
import com.example.demo.entity.TransactionData;

public interface AccountTxnService {

	 int createAccount(AccountData accountData);
	 
	 AccountData getAccountData(int accnumber);
	 
	 void addTXTData(TransactionData txtData , int accno);
	 
	 void sendMailAttachment();
}
