package com.afs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
