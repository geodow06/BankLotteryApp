package com.qa.PrizeChecker;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.qa.PrizeChecker.Service.PrizeCheckerService;



@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public PrizeCheckerService implementation() {
		return new PrizeCheckerService();
	}

}
