package com.afs.services;

import java.util.List;

import com.afs.model.Account;

public interface AccountService {
	public boolean saveOrUpdateAccount(Account account);

	public List<Account> getAccounts();

	public Account getAccount(Long accountNo);

	public boolean deleteAccount(Long accountNo);
	
}
