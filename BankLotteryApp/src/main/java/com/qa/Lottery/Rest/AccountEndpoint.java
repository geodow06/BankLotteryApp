package com.qa.Lottery.Rest;

import java.util.List;import javax.xml.ws.Response;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qa.Lottery.Domain.Account;
import com.qa.Lottery.Service.AccountService;

@RestController
public class AccountEndpoint {

	private AccountService accountService;
	private RestTemplate restTemplate;

	public AccountEndpoint(AccountService accountService, RestTemplate restTemplate) {
		this.accountService = accountService;
		this.restTemplate = restTemplate;
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
	public void createAccount(Account account) {
		account.setAccountId(this.restTemplate.exchange("http://localhost:8081/getNumber", HttpMethod.GET, null, String.class).getBody());
		//this.restTemplate.postForLocation("http://localhost:8081/actuator/refresh", null);
		this.accountService.createAccount(account);
		
	}
	
	@DeleteMapping("/removeAccount/{id}")
	public void removeAccount(@PathVariable Long id) {
		this.accountService.removeAccount(id);
	}
	
	@DeleteMapping("/removeAll")
	public void removeAll() {
		this.accountService.removeAll();
	}
	
	@PutMapping("/updateAccount/{id}")
	public void updateAccount(Account account,@PathVariable Long id) {
		this.accountService.updateAccount(account, id);
	}
	
	@GetMapping("/checkWinner/{id}")
	public String checkWinner(@PathVariable Long id) {
		String number = this.accountService.getAccountById(id).getAccountId();
		return this.restTemplate.exchange("http://localhost:8082/checkWinner/" + number, HttpMethod.POST, null, String.class).getBody();
	}
}
