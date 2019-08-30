package com.afs.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	public String newAccount(Model model) {
		model.addAttribute("account", new Account());
		return "newAccount";
	}

	@RequestMapping("/showAccount")
	public String showAccount() {
		return "showAccount";
	}

	/*
	 * @RequestMapping(value = "/saveAccount", method = RequestMethod.POST) public
	 * String saveAccount(Model model, HttpServletRequest request) { String acNo =
	 * request.getParameter("accountNo"); String custName =
	 * request.getParameter("accountHolderName"); String balance =
	 * request.getParameter("balance");
	 * 
	 * Account acc = new Account(Integer.parseInt(acNo), custName,
	 * Integer.parseInt(balance)); // model.addAttribute("accountNumber", acNo); //
	 * model.addAttribute("accountHolderNumber", custName); //
	 * model.addAttribute("balance", balance); model.addAttribute("account", acc);
	 * return "showAccount"; }
	 */

//	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
//	public String saveAccount(Model model, @RequestParam("accountNo") String acNo,
//			@RequestParam("accountHolderName") String custName, @RequestParam("balance") String balance) {
//		Account acc = new Account(Integer.parseInt(acNo), custName, Integer.parseInt(balance));
//		model.addAttribute("account", acc);
//		return "showAccount";
//	}

	@RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
	public String saveAccount(@Valid @ModelAttribute("account") Account account, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Has error return newAccount");
			return "newAccount";
		} else {
			System.out.println("No error return showAccount");
			return "showAccount";
		}
	}
}
