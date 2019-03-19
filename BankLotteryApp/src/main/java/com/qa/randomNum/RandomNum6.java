package com.qa.randomNum;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomNum6 implements RandomNumInterface {
	public String randomNum() {
		String accountId = "";
		Random randNum = new Random();
		String letter = Character.toString((char) (randNum.nextInt(3) + 97));
		String number = Integer.toString(randNum.nextInt((int) Math.pow(10, 6)));
		if (number.length() < 6) {
			number = String.format("%06d", Integer.parseInt(number));
		}
		accountId = letter + number;
		return accountId;
	}
}
