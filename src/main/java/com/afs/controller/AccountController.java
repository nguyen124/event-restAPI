package com.afs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.afs.model.Account;

@Controller
public class AccountController {
	@RequestMapping("/about")
	public String showAboutPage() {
		return "about";
	}

	@RequestMapping("/newAccount")
	public String newAccount() {
		return "newAccount";
	}

	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveAccount(Model model, HttpServletRequest request) {
		String acNo = request.getParameter("accountNo");
		String custName = request.getParameter("accountHolderName");
		String balance = request.getParameter("balance");

		Account acc = new Account(Integer.parseInt(acNo), custName, Integer.parseInt(balance));
//		model.addAttribute("accountNumber", acNo);
//		model.addAttribute("accountHolderNumber", custName);
//		model.addAttribute("balance", balance);
		model.addAttribute("account", acc);
		return "showAccount";
	}
}
