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
	public boolean saveOrUpdateAccount(Account account) {
		accountDAO.saveOrUpdateAccount(account);
		return false;
	}

	@Transactional
	public List<Account> getAccounts() {
		return accountDAO.getAccounts();
	}

	@Transactional
	public Account getAccount(Long accountNo) {
		return accountDAO.getAccount(accountNo);
	}

	@Transactional
	public boolean deleteAccount(Long accountNo) {
		return accountDAO.deleteAccount(accountNo);
	}

}
