package com.example.BankLotteryApp.Business;

import java.util.Random;

import org.springframework.stereotype.Component;

public class AccNumGen8  implements AccNumGen{
	Random rand = new Random();
	
	public String generateAccountNumber() {
		String accountNum;
		accountNum = accountLetter();
		accountNum = accountNum + accountNumberGenerator();
		return accountNum;
	}
	
	public String accountLetter() {
		int letter = rand.nextInt(2)+1;
		switch (letter){
		case 0:
			return "a";
		case 1:
			return "b";
		case 2:
			return "c";
		default:
			return "";
		}
	}

	@Override
	public String accountNumberGenerator() {
		String eightDigits="";
		for(int i=0;i<8;i++) {
			int a = rand.nextInt(9)+0;
			eightDigits= eightDigits + a;
		}
		return eightDigits;
	}
}
