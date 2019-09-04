package com.afs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afs.dao.AccountDAO;
import com.afs.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountDAO;

	public boolean saveAccount(Account account) {
		accountDAO.saveAccount(account);
		return false;
	}

}
