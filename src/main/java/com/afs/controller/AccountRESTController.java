package com.afs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.afs.model.Account;
import com.afs.services.AccountService;

@RestController
public class AccountRESTController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public ResponseEntity<List<Account>> getAll() {
		List<Account> accounts = accountService.getAccounts();
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);

	}

	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public ResponseEntity<Boolean> saveAccount(@RequestBody Account account, BindingResult result) {
		accountService.saveOrUpdateAccount(account);
		if (result.hasErrors()) {
			System.out.println("Has error return newAccount");
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> updateAccount(@PathVariable("id") Long id, @RequestBody Account account) {
		account.setId(id);
		Boolean acc = accountService.saveOrUpdateAccount(account);
		return new ResponseEntity<Boolean>(acc, HttpStatus.OK);
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> deleteAccount(@PathVariable("id") Long id) {
		Boolean result = accountService.deleteAccount(id);
		return new ResponseEntity<Boolean>(result, HttpStatus.OK);
	}

}
