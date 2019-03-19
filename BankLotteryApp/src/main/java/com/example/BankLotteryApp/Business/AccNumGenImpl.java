package com.example.BankLotteryApp.Business;

import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AccNumGenImpl {

	private Random randNum = new Random();
	
	private char initLetter;
	private long accountDigits;
	private String accountNum;
	
	public String createAccountNum() {
		
		int newRandonNum = randNum.nextInt(3);
		
		switch (newRandonNum) {
		case 0: accountDigits = (long) (Math.random() * 899999 + 100000);
		break;
		case 1: accountDigits = (long) (Math.random() * 89999999 + 10000000);
		break;
		case 2: accountDigits = (long) (Math.random() * 8999999999l + 1000000000);
		break;
		}
		
		newRandonNum = randNum.nextInt(3);
		
		switch (newRandonNum) {
		case 0: initLetter = 'a';
		break;
		case 1: initLetter = 'b';
		break;
		case 2: initLetter = 'c';
		break;
		}
		
		accountNum = "" + initLetter + accountDigits;
		
		return accountNum;
	}
}
