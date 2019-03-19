package com.example.BankLotteryApp.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankLotteryApp.Business.AccountService;
import com.example.BankLotteryApp.Entities.Account;

@RestController
public class AccountController {

	private AccountService svc;

	public AccountController(AccountService svc) {
		this.svc = svc;
	}

	@PostMapping("/createAccount")
	public void createAccount(Account account) {
		svc.createAccount(account);

	}
}
