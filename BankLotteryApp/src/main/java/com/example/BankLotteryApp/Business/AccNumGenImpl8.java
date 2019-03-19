package com.example.BankLotteryApp.Business;

import java.util.HashMap;
import java.util.Random;

public class AccNumGenImpl8 implements AccNumGenService {
	@Override
	public String generateNumber() {

		Random rand = new Random();
		int letterChoice = rand.nextInt(3);
		char[] letters = ("abc").toCharArray();
		int accountNumber = 10000000 + rand.nextInt(90000000);
		String response = Integer.toString(accountNumber);
		return letters[letterChoice] + response;
	}
}
