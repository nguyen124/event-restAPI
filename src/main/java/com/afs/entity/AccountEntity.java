package com.afs.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity {
	@Id
	@Column(name = "accountNo")
	private int accNo;
	@Column(name = "accountHolderName")
	private String accHolderName;
	@Column(name = "balance")
	private int balance;
	@Column(name = "dob")
	private Date dob;
	@Column(name = "psCode")
	private String psCode;

	public AccountEntity() {

	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
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

	@Override
	public int hashCode() {
		return this.accNo;
	}

	@Override
	public boolean equals(Object obj) {
		// checking if both the object references are
		// referring to the same object.
		if (this == obj)
			return true;

		// it checks if the argument is of the
		// type Geek by comparing the classes
		// of the passed argument and this object.
		// if(!(obj instanceof Geek)) return false; ---> avoid.
		if (obj == null || obj.getClass() != this.getClass())
			return false;

		// type casting of the argument.
		AccountEntity account = (AccountEntity) obj;

		// comparing the state of argument with
		// the state of 'this' Object.
		return (account.accNo == this.accNo);
	}
}
