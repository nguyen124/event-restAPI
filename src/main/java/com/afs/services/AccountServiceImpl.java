package com.afs.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.afs.dao.AccountDAO;
import com.afs.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountDAO;

	@Transactional
	public boolean saveAccount(Account account) {
		accountDAO.saveAccount(account);
		return false;
	}

	@Transactional
	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	@Transactional
	public Account getAccount(Integer accountNo) {
		return accountDAO.getAccount(accountNo);
	}

	@Transactional
	public boolean deleteAccount(int accountNo) {
		return accountDAO.deleteAccount(accountNo);
	}

	@Transactional
	public Account updateAccount(int id, Account account) {
		return accountDAO.updateAccount(id, account);
	}

}
