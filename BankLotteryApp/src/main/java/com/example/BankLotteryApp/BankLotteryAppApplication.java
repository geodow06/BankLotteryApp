package com.example.BankLotteryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.BankLotteryApp.Business.AccNumGenService;
import com.example.BankLotteryApp.Repository.HashMapRepo;

@SpringBootApplication 
@EnableWebMvc
public class BankLotteryAppApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BankLotteryAppApplication.class, args);
		AccNumGenService numGen = (AccNumGenService) ac.getBean("numGen");
		HashMapRepo repo = (HashMapRepo)ac.getBean("storeAccounts"); 
		String accountNumber = numGen.generateNumber();
		System.out.println(accountNumber);
		System.out.println(repo.storeAccounts(accountNumber));
	}
}
