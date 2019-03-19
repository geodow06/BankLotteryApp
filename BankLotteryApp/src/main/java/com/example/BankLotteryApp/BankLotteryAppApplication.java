package com.example.BankLotteryApp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.BankLotteryApp.Business.AccNumContainer;
import com.example.BankLotteryApp.Business.AccNumGenImpl;

@SpringBootApplication
public class BankLotteryAppApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(BankLotteryAppApplication.class, args);
		
		AccNumContainer acnc = (AccNumContainer) ac.getBean("accNumContainer");
		
		String newAccountName = "Greg";
		
		ac.getBean("accNumGenImpl");
		
		
		for(int i = 0; i < 10; i++) {
			AccNumGenImpl numGen = (AccNumGenImpl) ac.getBean("accNumGenImpl");
			String newAccountNum = numGen.createAccountNum();
			System.out.println(newAccountNum);
			acnc.addAccountToMap(newAccountNum, newAccountName);
		}
	}

}
