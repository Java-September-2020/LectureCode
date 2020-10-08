package com.matthew.football.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.matthew.football.models.Owner;
import com.matthew.football.services.OwnerService;

@Controller
public class OwnerController {
	@Autowired 
	private OwnerService oService;
	
	
	@RequestMapping("/")
	private String index(Model viewModel) {
		List<Owner> owner = this.oService.allOwners();
		viewModel.addAttribute("owners", owner);
		return "landing.jsp";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("owners") Long id) {
		if(session.getAttribute("owner_id") == null) {
			session.setAttribute("owner_id", id);
		}
		 return "redirect:/teams";
	}
}
