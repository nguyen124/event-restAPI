package com.afs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping(value = { "", "/index", "/index*" })
	public String index() {
		return "testRequestMapping";
	}

	@RequestMapping(value = { "/name" })
	public String methodWithParams(
			@RequestParam(value = "username", required = false, defaultValue = "Guest") String username, Model model) {
		model.addAttribute("username", username);
		System.out.println("page requested by: " + username);
		return "testRequestMapping";
	}

	@RequestMapping(value = "/dynamic/{category:[a-z]+}/{username}")
	public String dynamicUrl(@PathVariable("username") String userName) {
		return "testRequestMapping";
	}

	@RequestMapping("*")
	public String fallBAckPage() {
		return "fileNotFound";
	}
}
