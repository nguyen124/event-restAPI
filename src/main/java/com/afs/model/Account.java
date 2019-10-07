package com.afs.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Account {

	private Long id;

	@Size(min = 2, max = 20, message = "Invalid length for Account Holder Name")
	@Pattern(regexp = "[A-Za-z(\\s)]+")
	private String accountHolderName;

	@NotNull(message = "balance is required")
	@Min(value = 500, message = "Minimum balance is 500")
	private Integer balance;

	@NotNull(message = "dob can't be blank")
	@Past(message = "DoB can't be in future")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dob;

	private String psCode;

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
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
		return String.format("{accountNo: %d, holder: %s}", this.id, this.accountHolderName);
	}
}
