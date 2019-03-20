package com.qa.PrizeChecker.Service;

public class PrizeCheckerService {

	public String checkWinner(String number) {
		if (number.charAt(0) == 'a') {
			return "$0";
		} else if (number.charAt(0) == 'b') {
			if (number.length() == 7) {
				return "$50";
			} else if (number.length() == 9) {
				return "$500";
			} else {
				return "$5000";
			}
		} else {
			if (number.length() == 7) {
				return "$100";
			} else if (number.length() == 9) {
				return "$750";
			} else {
				return "$10000";
			}
		}
	}
}
