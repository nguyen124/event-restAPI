package com.afs.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.afs.validations.PSCode;

public class Account {

	@Size(min = 2, max = 20, message = "Invalid length for Account Holder Name")
	@Pattern(regexp = "[A-Za-z(\\s)]+")
	private String accountHolderName;

	private Integer accountNo;
	@NotNull(message = "balance is required")
	@Min(value = 500, message = "Minimum balance is 500")
	private Integer balance;
	@NotNull(message = "dob can't be blank")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Past(message = "DoB can't be in future")
	private Date dob;
	@PSCode()
	String psCode;

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

	public String getPsCode() {
		return psCode;
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

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

}
