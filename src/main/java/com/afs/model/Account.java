package com.afs.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class Account {
	@NotNull(message = "accountHolderName can't be blank")
	@NotEmpty(message = "accountHolderName can't be blank")
	private String accountHolderName;
	@NotNull(message = "Account# can't be blank")
	private Integer accountNo;
	@NotNull(message = "balance is required")
	private Integer balance;
	@NotNull(message = "dob can't be blank")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date dob;

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

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public Integer getBalance() {
		return balance;
	}

	public Date getDob() {
		return dob;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
