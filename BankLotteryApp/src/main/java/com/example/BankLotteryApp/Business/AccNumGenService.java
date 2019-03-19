package com.example.BankLotteryApp.Business;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public interface AccNumGenService {
	@Bean
	public String generateNumber();
}
