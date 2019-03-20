package com.qa.RandomNum.Service;

import java.util.Random;

import org.springframework.stereotype.Component;

public class RandomNum10 implements RandomNumInterface {
	public String randomNum() {
		String accountId = "";
		Random randNum = new Random();
		String letter = Character.toString((char) (randNum.nextInt(3) + 97));
		String number = Integer.toString(randNum.nextInt((int) Math.pow(10, 10)));
		if (number.length() < 10) {
			number = String.format("%010d", Integer.parseInt(number));
		}
		accountId = letter + number;
		return accountId;
	}
}
