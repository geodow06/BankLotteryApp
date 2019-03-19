package com.example.BankLotteryApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.BankLotteryApp.Business.AccNumGenImpl6;
import com.example.BankLotteryApp.Business.AccNumGenImpl8;
import com.example.BankLotteryApp.Business.AccNumGenImpl10;
import com.example.BankLotteryApp.Business.AccNumGenService;
import com.example.BankLotteryApp.Repository.HashMapRepo;
import com.example.BankLotteryApp.Repository.RepositoryInterface;

@Configuration
public class AppConfig {
	@Bean
	public AccNumGenService numGen() {
		return new AccNumGenImpl6();
	}

	@Bean
	public RepositoryInterface storeAccounts() {
		return new HashMapRepo();
	}
}
