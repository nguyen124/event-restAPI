package com.afs.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afs.entity.AccountEntity;
import com.afs.model.Account;

@Repository
@Transactional
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveAccount(Account account) {
		boolean saveFlag = true;
		AccountEntity accEnt = new AccountEntity();
		accEnt.setAccNo(account.getAccountNo());
		accEnt.setAccHolderName(account.getAccountHolderName());
		accEnt.setBalance(account.getBalance());
		accEnt.setDob(account.getDob());
		accEnt.setPsCode(account.getPsCode());
		try {
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.save(accEnt);

		} catch (Exception e) {
			e.printStackTrace();
			saveFlag = false;
		}
		return saveFlag;
	}

}
