package com.example.BankLotteryApp.Business;

import java.util.HashMap;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class AccNumGenImpl6 implements AccNumGenService {
	@Override
	public String generateNumber() {
		Random rand = new Random();
		HashMap<String, String> accountNumbers = new HashMap<>();
		String username = "gewg";
		int letterChoice = rand.nextInt(3);
		int digitChoice = rand.nextInt(3);
		Character letter = new Character('a');
		int accountNumber = 0;
		String response = "";
//		Char[] = "abc";
		switch (letterChoice) {
		case 0:
			letter = 'a';
			break;
		case 1:
			letter = 'b';
			break;
		case 2:
			letter = 'c';
			break;
		}

		accountNumber = 100000 + rand.nextInt(900000);
		response = Integer.toString(accountNumber);

		if (accountNumbers.containsValue(letter + response)) {
			return "that account number is in use";
		} else {
//			accountNumbers.put(key, value);
			accountNumbers.put(username, letter + response);
			return letter + response;
		}

	}
}
