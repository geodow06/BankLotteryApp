package com.example.BankLotteryApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.BankLotteryApp.Business.AccNumGen;
import com.example.BankLotteryApp.Business.AccNumGen6;
import com.example.BankLotteryApp.Repository.AccountRepository;
import com.example.BankLotteryApp.Repository.HashmapRepo;

@Configuration
public class AppConfig {
	@Bean
	public AccNumGen generate() {
		return new AccNumGen6();
	}
	@Bean
	public AccountRepository repo() {
		return new HashmapRepo();
	}
}
