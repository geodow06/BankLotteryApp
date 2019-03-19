package com.qa.Repository;

import java.util.HashMap;

import com.qa.Domain.Account;
import com.qa.randomNum.RandomNum10;
import com.qa.randomNum.RandomNum6;
import com.qa.randomNum.RandomNum8;

public class AccountMapHash implements AccountMap {
	
	HashMap<String, Account> hashMap = new HashMap<String, Account>();
	public HashMap<String, Account> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<String, Account> hashMap) {
		this.hashMap = hashMap;
	}

	RandomNum6 rand6 = new RandomNum6();
	RandomNum8 rand8 = new RandomNum8();
	RandomNum10 rand10 = new RandomNum10();
	
	@Override
	public String addAccount(String name, String password) {
		if (hashMap.containsValue(new Account(name, password))) {
			return "Account already exists";
		}
		else {
			hashMap.put(rand10.randomNum(), new Account(name, password));
			return "Account added";
		}
	}
}
