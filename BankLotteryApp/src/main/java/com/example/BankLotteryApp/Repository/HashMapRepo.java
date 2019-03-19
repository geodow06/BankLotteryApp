package com.example.BankLotteryApp.Repository;

import java.util.HashMap;

public class HashMapRepo implements RepositoryInterface {
	HashMap<String, String> accountNumbers = new HashMap<>();

	public String storeAccounts(String accountNumber) {
		if (accountNumbers.containsValue(accountNumber)) {
			return "account already exists";
		} else {
			accountNumbers.put(accountNumber, accountNumber);
			return "account " + accountNumber + " added";
		}
	}
}
