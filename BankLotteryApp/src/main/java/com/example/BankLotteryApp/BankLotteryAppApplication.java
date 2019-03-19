package com.example.BankLotteryApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.BankLotteryApp.Business.AccNumGenImpl10;
import com.example.BankLotteryApp.Business.AccNumGenImpl8;
import com.example.BankLotteryApp.Business.AccNumGenImpl6;


@SpringBootApplication
public class BankLotteryAppApplication {

	public static void main(String[] args) {
		
		ApplicationContext ac = SpringApplication.run(BankLotteryAppApplication.class, args);
		AccNumGenImpl6 numGen8 = (AccNumGenImpl6) ac.getBean("accNumGenImpl6");
		System.out.println(numGen8.generateNumber());
	}

}
