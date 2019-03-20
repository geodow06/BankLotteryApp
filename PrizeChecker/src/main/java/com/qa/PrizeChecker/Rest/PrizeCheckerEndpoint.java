package com.qa.PrizeChecker.Rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.PrizeChecker.Service.PrizeCheckerService;

@RestController
public class PrizeCheckerEndpoint {

	private PrizeCheckerService prizeCheckerService;

	public PrizeCheckerEndpoint(PrizeCheckerService prizeCheckerService) {
		this.prizeCheckerService = prizeCheckerService;
	}

	@PostMapping("/checkWinner/{number}")
	public String checkWinner(@PathVariable String number) {
		return this.prizeCheckerService.checkWinner(number);
	}
}
