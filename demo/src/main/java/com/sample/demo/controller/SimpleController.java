package com.sample.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

	@Value("${spring.application.name}")
	String appName;

	@GetMapping("/thymleaf")
	public String homePage(Model model) {
		model.addAttribute("appName", appName);
		return "home";
	}
}
