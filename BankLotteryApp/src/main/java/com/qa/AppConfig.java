package com.qa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.qa.Repository.AccountMap;
import com.qa.Repository.AccountMapHash;
import com.qa.randomNum.RandomNum6;
import com.qa.randomNum.RandomNumInterface;

@Configuration
public class AppConfig {
	@Bean
	public RandomNumInterface numGen() {
		return new RandomNum6();
	}

	@Bean
	public AccountMap storeAccounts() {
		return new AccountMapHash();
	}
}
