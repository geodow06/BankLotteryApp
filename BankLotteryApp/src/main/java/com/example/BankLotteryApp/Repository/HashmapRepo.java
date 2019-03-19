package com.example.BankLotteryApp.Repository;

import java.util.HashMap;

public class HashmapRepo implements AccountRepository {
	HashMap<String, String> accounts = new HashMap<>();
	

	@Override
	public String storeAccount(String account) {
		if(accounts.containsValue(account)) {
			return "Account already exists";
		}else {
			accounts.put(account, account);
			return "Account added!";
		}
		
	}

}
