package com.example.BankLotteryApp.Business;

import org.springframework.stereotype.Service;

import com.example.BankLotteryApp.Entities.Account;
import com.example.BankLotteryApp.Repository.AccountRepository;

@Service
public class AccountService {
	private AccountRepository repo;

	public AccountRepository getAccountRepository() {
		return repo;
	}

	public AccountService(AccountRepository repo) {
		this.repo = repo;
	} 
	
	public void createAccount(Account account) { 
		repo.save(account);
	}
}
