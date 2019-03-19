package com.example.BankLotteryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.BankLotteryApp.Business.AccNumGenService;


@SpringBootApplication
public class BankLotteryAppApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BankLotteryAppApplication.class, args);
		AccNumGenService numGen = (AccNumGenService) ac.getBean("numGen");
		System.out.println(numGen.generateNumber());
	}

}
