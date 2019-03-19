package com.example.BankLotteryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import repository.HashmapRepo;
import service.AccNumGen6;

@SpringBootApplication
public class BankLotteryAppApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BankLotteryAppApplication.class, args);
		AccNumGen6 genny = (AccNumGen6) ac.getBean("generate");
		HashmapRepo repo = (HashmapRepo) ac.getBean("repo");
		repo.storeAccount(genny.generateAccountNumber());
		for(int i=0;i<10;i++) {System.out.println("My Account Num: "+genny.generateAccountNumber());}
	}

}
