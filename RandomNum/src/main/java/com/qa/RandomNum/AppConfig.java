package com.qa.RandomNum;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.qa.RandomNum.Service.RandomNum10;
import com.qa.RandomNum.Service.RandomNum6;
import com.qa.RandomNum.Service.RandomNum8;
import com.qa.RandomNum.Service.RandomNumInterface;

@Configuration
public class AppConfig {

	@Bean
	@Scope("prototype")
	public RandomNumInterface implementation() {
		Random rand = new Random();	
		int num = rand.nextInt(100);
		if (num >= 95) {
			return new RandomNum10();
		} else if (num >= 65) {
			return new RandomNum8();
		} else {
			return new RandomNum6();
		}
	}

}
