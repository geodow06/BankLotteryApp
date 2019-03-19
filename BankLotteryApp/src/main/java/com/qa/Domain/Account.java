package com.qa.Domain;

public class Account {
	
	public Account() {
		
	}

	public Account(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if (this.getName() == ((Account) obj).getName() && this.getPassword() == ((Account) obj).getPassword() && this.getId() == ((Account) obj).getId()) {
			return true;
		}
		return false;
	}

	private String name;
	private String password;
	private String id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
