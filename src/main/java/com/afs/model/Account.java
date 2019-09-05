package com.afs.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.afs.validations.PSCode;

public class Account {

	private Integer accountNo;

	@Size(min = 2, max = 20, message = "Invalid length for Account Holder Name")
	@Pattern(regexp = "[A-Za-z(\\s)]+")
	private String accountHolderName;

	@NotNull(message = "balance is required")
	@Min(value = 500, message = "Minimum balance is 500")
	private Integer balance;

	@NotNull(message = "dob can't be blank")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Past(message = "DoB can't be in future")
	private Date dob;

	@PSCode()
	private String psCode;

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

	@Override
	public String toString() {
		return String.format("{accountNo: %d, holder: %s}", this.accountNo, this.accountHolderName);
	}
}
