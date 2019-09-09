package com.afs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.afs.model.Account;
import com.afs.services.AccountService;

@Controller
public class AccountController {

	@Autowired
	private AccountService accountService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor ste = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, ste);
	}

	@RequestMapping("/newAccount")
	public String newAccount(Model model) {
		model.addAttribute("account", new Account());
		return "newAccount";
	}

	@RequestMapping("/newAccount2")
	public String newAccount2(Model model) {
		model.addAttribute("account", new Account());
		return "newAccount2";
	}

	@RequestMapping("/newUser")
	public String newUser(Model model) {
		model.addAttribute("account", new Account());
		return "account";
	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Has error return newAccount");
			return "newAccount";
		} else {
			System.out.println("No error return showAccount");
			accountService.saveAccount(account);
			return "redirect:/list";
		}
	}

	@GetMapping("/list")
	public String listAccounts(Model model) {
		List<Account> accounts = accountService.getAccounts();
		model.addAttribute("accounts", accounts);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("username", name);
		return "listAccounts";
	}

	@GetMapping("/edit")
	public String updateAccount(@RequestParam("accountNo") int accountNo, Model model) {
		Account account = accountService.getAccount(new Integer(accountNo));
		model.addAttribute("account", account);
		return "newAccount";
	}

	@GetMapping("/delete")
	public String deleteAccount(@RequestParam("accountNo") int accountNo, Model model) {
		accountService.deleteAccount(accountNo);
		return "redirect:/list";
	}

	@RequestMapping("/user/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid Username or Password");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully");
		}
		return "login";
	}
}
