package com.example.BankLotteryApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import repository.AccountRepository;
import repository.HashmapRepo;
import service.AccNumGen;
import service.AccNumGen6;

@Configuration
public class AppConfig {
	@Bean
	public AccNumGen accountNumgenerator() {
		return new AccNumGen6();
	}
	@Bean
	public AccountRepository repo() {
		return new HashmapRepo();
	}
}
