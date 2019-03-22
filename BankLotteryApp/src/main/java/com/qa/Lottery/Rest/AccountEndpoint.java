package com.qa.Lottery.Rest;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.Lottery.Domain.Account;
import com.qa.Lottery.Service.AccountService;

@RestController
public class AccountEndpoint {

	private AccountService accountService;
	private RestTemplate restTemplate;
	private JmsTemplate jmsTemplate;

	public AccountEndpoint(AccountService accountService, RestTemplate restTemplate, JmsTemplate jmsTemplate) {
		this.accountService = accountService;
		this.restTemplate = restTemplate;
		this.jmsTemplate = jmsTemplate;
	}
	
	@GetMapping("/getAllAccounts")
	public List<Account> getAllAccounts() {
		return this.accountService.getAllAccounts();
	}
	
	@GetMapping("/getAccountById/{id}")
	public Account getAccountById(@PathVariable Long id) {
		return this.accountService.getAccountById(id);
	}
	
	@PostMapping("/createAccount")
	public Long createAccount(@RequestBody Account account) {
		account.setAccountId(this.restTemplate.exchange("http://localhost:8081/getNumber", HttpMethod.GET, null, String.class).getBody());
		Long num = this.accountService.createAccount(account);
		account.setId(num);
		jmsTemplate.convertAndSend("Help Me", account);
		return num;
		
	}
	
	@DeleteMapping("/removeAccount/{id}")
	public boolean removeAccount(@PathVariable Long id) {
		return this.accountService.removeAccount(id);
	}
	
	@DeleteMapping("/removeAll")
	public boolean removeAll() {
		return this.accountService.removeAll();
	}
	
	@PutMapping("/updateAccount/{id}")
	public String updateAccount(@RequestBody Account account,@PathVariable Long id) {
		return this.accountService.updateAccount(account, id);
	}
	
	@GetMapping("/checkWinner/{id}")
	public String checkWinner(@PathVariable Long id) {
		String number = this.accountService.getAccountById(id).getAccountId();
		return this.restTemplate.exchange("http://localhost:8082/checkWinner/" + number, HttpMethod.POST, null, String.class).getBody();
	}
}
