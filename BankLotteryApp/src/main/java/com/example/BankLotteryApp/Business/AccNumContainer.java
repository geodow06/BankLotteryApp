package com.example.BankLotteryApp.Business;

import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class AccNumContainer {

	private HashMap<String, String> accountNums = new HashMap<>();
	
	public void addAccountToMap(String accountNum, String accountName) {
		accountNums.put(accountNum, accountName);
		System.out.println("Account added to Hashmap");
	}
}
