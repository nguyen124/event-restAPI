package com.afs.model;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/user")
public class User {

	private Long accountNo;

	private String accountHolderName;

	private Integer balance;

	private Date dob;

	private String psCode;

	public User() {
		accountNo = 0L;
	}

	public User(Long accountNo, String username, Integer balance, Date dob, String psCode) {
		this.accountNo = accountNo;
		this.accountHolderName = username;
		this.balance = balance;
		this.dob = dob;
		this.psCode = psCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (accountNo != other.accountNo) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNo ^ (accountNo >>> 32));
		return result;
	}

	@Override
	public String toString() {
		return "User [AccountNo=" + accountNo + ", username=" + accountHolderName + ", balance=" + balance + ", dob="
				+ dob + ", psCode=" + psCode + "]";
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPsCode() {
		return psCode;
	}

	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

}
