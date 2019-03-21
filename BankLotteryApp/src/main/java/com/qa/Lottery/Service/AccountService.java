package com.qa.Lottery.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.Lottery.Domain.Account;
import com.qa.Lottery.Repository.AccountRepo;

@Service
public class AccountService {

	private AccountRepo accountRepo;

	public AccountService(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	public List<Account> getAllAccounts() {
		return this.accountRepo.findAll();
	}

	public Account getAccountById(Long id) {
		return this.accountRepo.findById(id).get();
	}

	public Long createAccount(Account account) {
		this.accountRepo.save(account);
		
		return account.getId();
	}

	public boolean removeAccount(Long id) {
		this.accountRepo.deleteById(id);
		return this.accountRepo.existsById(id);
	}

	public boolean removeAll() {
		this.accountRepo.deleteAll();
		return this.accountRepo.count() == 0;
	}

	public String updateAccount(Account account, Long id) {
		if (this.accountRepo.existsById(id)) {
			if (account.getName() != null) {
				this.accountRepo.getOne(id).setName(account.getName());
			}
			if (account.getAccountId() != null) {
				this.accountRepo.getOne(id).setName(account.getAccountId());
			}
			return "Done";
		} else {
			return "No such account";
		}
	}
}
