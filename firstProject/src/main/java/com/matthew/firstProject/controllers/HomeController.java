package com.matthew.firstProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/processData", method=RequestMethod.POST)
	public String process(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("color") String color, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("email", email);
		viewModel.addAttribute("color", color);
		return "result.jsp";
	}
	
}
