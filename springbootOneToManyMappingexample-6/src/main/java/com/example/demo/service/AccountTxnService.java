package com.example.demo.service;

import com.example.demo.entity.AccountData;

public interface AccountTxnService {

	 int createAccount(AccountData accountData);
	 
	 AccountData getAccountData(int accnumber);
}
