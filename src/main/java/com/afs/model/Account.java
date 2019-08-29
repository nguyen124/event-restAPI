package com.afs.model;

public class Account {
	private Integer accountNo;
	private String accountHolderName;
	private Integer balance;

	public Account() {
		accountNo = 0;
		accountHolderName = "";
		balance = 0;
	}

	public Account(Integer accountNo, String accountHolderName, Integer balance) {
		super();
		this.accountNo = accountNo;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

}
