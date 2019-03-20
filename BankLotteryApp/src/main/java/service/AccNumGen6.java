package service;

import java.util.Random;
import repository.AccountRepository;

import repository.AccountRepository;

public class AccNumGen6 implements AccNumGen {
	Random rand = new Random();
	AccountRepository repo;
	
	public String generateAccountNumber() {
		String accountNum;
		accountNum = accountLetter();
		accountNum = accountNum + accountNumberGenerator();
		repo.storeAccount(accountNum);
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
		String sixDigits="";
		for(int i=0;i<6;i++) {
			int a = rand.nextInt(9)+0;
			sixDigits= sixDigits + a;
		}
		return sixDigits;
	}
}
