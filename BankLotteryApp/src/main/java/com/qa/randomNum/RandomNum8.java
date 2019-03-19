package com.qa.randomNum;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomNum8 implements RandomNumInterface {
	public String randomNum() {
		String accountId = "";
		Random randNum = new Random();
		String letter = Character.toString((char) (randNum.nextInt(3) + 97));
		String number = Integer.toString(randNum.nextInt((int) Math.pow(10, 8)));
		if (number.length() < 8) {
			number = String.format("%08d", Integer.parseInt(number));
		}
		accountId = letter + number;
		return accountId;
	}
}
