package com.qa.Lottery.Domain;

public class Account {
	
	public Account() {
		
	}
	
	public Account(Long id, String name, String accountId) {
		this.accountId = accountId;
		this.name = name;
		this.id = id;
	}

	private Long id;
	private String name;
	private String accountId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Account{id=%s, name=%s, accountId=%s}", getId(), getName(), getAccountId());
	}

}
