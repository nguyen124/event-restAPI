package com.afs.dao;

import java.util.List;

import com.afs.model.Account;

public interface AccountDAO {
	public boolean saveAccount(Account account);

	public List<Account> getAccounts();
}
