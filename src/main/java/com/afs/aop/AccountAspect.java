package com.afs.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.afs.dao.AccountDAO;
import com.afs.model.Account;

@Aspect
@Component
public class AccountAspect {

	@Before("execution(* com.afs.dao.AccountDAOImpl.saveAccount(..))")
	public void validateAccount(JoinPoint joinPoint) {
		System.out.println("Validate account is being processed");
		Object[] args = joinPoint.getArgs();
		Account account = (Account) args[0];
		AccountDAO accountDAO = (AccountDAO) joinPoint.getTarget();
		int accountNo = account.getAccountNo();
		if (accountDAO.getAccount(accountNo) != null) {
			throw new RuntimeException("Account with account number: " + accountNo + " is already exist");
		}
	}
}
