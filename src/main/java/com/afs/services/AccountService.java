package com.afs.services;

import java.util.List;

import com.afs.model.Account;

public interface AccountService {
	public boolean saveAccount(Account account);

	public List<Account> getAccounts();

	public Account getAccount(Integer accountNo);

	public boolean deleteAccount(int accountNo);
	
	public Account updateAccount(int id, Account account);
}
