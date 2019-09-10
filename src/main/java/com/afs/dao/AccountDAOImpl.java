package com.afs.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
			// currentSession.saveOrUpdate(accEnt);
		} catch (Exception e) {
			e.printStackTrace();
			saveFlag = false;
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
				acc.setAccountNo(accountEntity.getAccNo());
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

	public Account getAccount(Integer accountNo) {
		Account account = null;
		try {
			Session session = sessionFactory.getCurrentSession();
			AccountEntity accountEntity = (AccountEntity) session.load(AccountEntity.class, accountNo);
			if (accountEntity != null) {
				account = new Account();
				account.setAccountNo(accountEntity.getAccNo());
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

	public boolean deleteAccount(int accountNo) {
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

	public Account updateAccount(int id, Account account) {
		try {
			if (id == account.getAccountNo()) {
				Session currentSession = sessionFactory.getCurrentSession();
				AccountEntity accountEntity = (AccountEntity) currentSession.load(AccountEntity.class, id);
				if (accountEntity != null) {
					accountEntity.setAccNo(account.getAccountNo());
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
