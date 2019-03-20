package com.qa.RandomNum.Rest;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.RandomNum.Service.RandomNumInterface;

@RestController
@RefreshScope
public class RandomNumEndpoint {
	
	private RandomNumInterface randomNumService;
	
	public RandomNumEndpoint(RandomNumInterface randomNumService) {
		this.randomNumService = randomNumService;
	}

	@GetMapping("/getNumber")
	public String getNumber() {
		return this.randomNumService.randomNum();
	}
}
