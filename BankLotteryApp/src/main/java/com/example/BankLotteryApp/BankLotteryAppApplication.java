package com.example.BankLotteryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.BankLotteryApp.Business.AccNumGen6;
import com.example.BankLotteryApp.Repository.HashmapRepo;

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
