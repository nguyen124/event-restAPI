package com.afs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/user")
public class User {

	@RequestMapping("/new")
	public String register() {
		return "register";
	}
}
