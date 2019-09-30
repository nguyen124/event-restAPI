package com.afs.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.afs.entity.AccountEntity;
import com.afs.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveOrUpdateAccount(Account account) {
		boolean saveFlag = false;
		if (account != null) {
			AccountEntity accEnt = new AccountEntity();
			accEnt.setId(account.getId());
			accEnt.setAccHolderName(account.getAccountHolderName());
			accEnt.setBalance(account.getBalance());
			accEnt.setDob(account.getDob());
			accEnt.setPsCode(account.getPsCode());
			Session currentSession = sessionFactory.getCurrentSession();
			try {
				currentSession.saveOrUpdate(accEnt);
				saveFlag = true;
			} catch (Exception e) {
				currentSession.clear();
				e.printStackTrace();
			}
		}
		return saveFlag;
	}

	public List<Account> getAccounts() {
		List<Account> list = new ArrayList<Account>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<AccountEntity> query = session.createQuery("From AccountEntity", AccountEntity.class);
			List<AccountEntity> accounts = query.getResultList();

			for (AccountEntity accountEntity : accounts) {
				Account acc = new Account();
				acc.setId(accountEntity.getId());
				acc.setAccountHolderName(accountEntity.getAccHolderName());
				acc.setBalance(accountEntity.getBalance());
				acc.setDob(accountEntity.getDob());
				acc.setPsCode(accountEntity.getPsCode());
				list.add(acc);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Account getAccount(Long accountNo) {
		Account account = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountNo);
			if (accountEntity != null) {
				account = new Account();
				account.setId(accountEntity.getId());
				account.setAccountHolderName(accountEntity.getAccHolderName());
				account.setBalance(accountEntity.getBalance());
				account.setDob(accountEntity.getDob());
				account.setPsCode(accountEntity.getPsCode());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			account = null;
		}
		return account;
	}

	public boolean deleteAccount(Long accountNo) {
		boolean deleteFlag = true;
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountNo);
			session.delete(accountEntity);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return deleteFlag;
	}

	public Account updateAccount(Long id, Account account) {
		try {
			if (id == account.getId()) {
				Session currentSession = sessionFactory.getCurrentSession();
				AccountEntity accountEntity = (AccountEntity) currentSession.load(AccountEntity.class, id);
				if (accountEntity != null) {
					accountEntity.setId(account.getId());
					accountEntity.setAccHolderName(account.getAccountHolderName());
					accountEntity.setBalance(account.getBalance());
					accountEntity.setDob(account.getDob());
					accountEntity.setPsCode(account.getPsCode());
				}
				currentSession.update(accountEntity);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		return account;
	}

}
