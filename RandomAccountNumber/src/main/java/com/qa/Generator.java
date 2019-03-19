package com.qa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Random;
@Configuration
public class Generator {
	private String abc = "abc";
	private String generate(int maxRand, int digits) {
		Random r = new Random();
		char letter1 = abc.charAt(r.nextInt(2));
		String letter2 = "" + letter1;
		int firstNum = r.nextInt(maxRand);
		String secondNum = "" + firstNum;
		String extend = "";
		while (extend.length() < (digits - secondNum.length())) {
			extend += "0";
		}
		return letter2 + extend + secondNum;
	}
		
	@Bean
	public String sixDigit() {
		return generate(999999, 6);
	}
	
	@Bean
	public String eightDigit() {
		return generate(99999999, 8);
	}
	
	@Bean
	public String tenDigit() {
		return generate(99999, 5) + generate(99999, 5).substring(1);
	}
	
	@Bean
	public String[] listOfUnique6(int length) {
		String[] listing = new String[length];
		for (int i = 0; i <= (length - 1); i++) {
			if (i == 0) {
				listing[0] = sixDigit();
			} else {
				String toAdd;
				do {
					toAdd = sixDigit();
				} while (Arrays.asList(listing).contains(toAdd));
				listing[i] = toAdd;
			}
		}
		return listing;
	}
	
	@Bean
	public String[] listOfUnique8(int length) {
		String[] listing = new String[length];
		for (int i = 0; i <= (length - 1); i++) {
			if (i == 0) {
				listing[0] = eightDigit();
			} else {
				String toAdd;
				do {
					toAdd = eightDigit();
				} while (Arrays.asList(listing).contains(toAdd));
				listing[i] = toAdd;
			}
		}
		return listing;
	}
	
	@Bean
	public String[] listOfUnique10(int length) {
		String[] listing = new String[length];
		for (int i = 0; i <= (length - 1); i++) {
			if (i == 0) {
				listing[0] = tenDigit();
			} else {
				String toAdd;
				do {
					toAdd = tenDigit();
				} while (Arrays.asList(listing).contains(toAdd));
				listing[i] = toAdd;
			}
		}
		return listing;
	}
}
