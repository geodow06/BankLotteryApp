package com.qa.Lottery.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	public Account() {
		
	}

	public Account(String name) {
		this.name = name;
	}
	
//	@Override
//	public boolean equals(Object obj) {
//		
//		if (this.getName() == ((Account) obj).getName() && this.getAccountId() == ((Account) obj).getAccountId() && this.getId() == ((Account) obj).getId()) {
//			return true;
//		}
//		return false;
//	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
