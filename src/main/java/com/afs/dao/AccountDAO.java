package com.afs.dao;

import java.util.List;

import com.afs.model.Account;

public interface AccountDAO {
	public boolean saveOrUpdateAccount(Account account);

	public List<Account> getAccounts();

	public Account getAccount(Long accountNo);

	public boolean deleteAccount(Long accountNo);

	public Account updateAccount(Long id, Account account);
}
