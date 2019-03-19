package com.example.BankLotteryApp.Business;

import java.util.HashMap;
import java.util.Random;

public class AccNumGenImpl8 implements AccNumGenService {
	@Override
	public String generateNumber() {

		Random rand = new Random();
		HashMap<String, String> accountNumbers = new HashMap<>();
		String username = "erh";
		int letterChoice = rand.nextInt(3);
		Character letter = new Character('a');
		int accountNumber = 0;
		String response = "";
		char[] letters = ("abc").toCharArray();

		accountNumber = 10000000 + rand.nextInt(90000000);
		response = Integer.toString(accountNumber);

		if (accountNumbers.containsValue(letter + response)) {
			return "that account number is in use";
		} else {
//			accountNumbers.put(key, value);
			accountNumbers.put(username, letters[letterChoice] + response);
			return letters[letterChoice] + response;
		}

	}

}
