package com.matthew.NinjaGold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@GetMapping("/")
	public String farmGold(HttpSession session, Model viewModel) {
		ArrayList<String> activity = new ArrayList<String>();
		if(session.getAttribute("activityLog") == null) {
			session.setAttribute("activityLog", activity);
		}
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		
		viewModel.addAttribute("gold", session.getAttribute("gold"));
		viewModel.addAttribute("activityLog", session.getAttribute("activityLog"));
		return "gold.jsp";
	}
	
	
	@PostMapping("/findgold")
	public String getGold(HttpSession session, @RequestParam("building") String building) {
		Random r = new Random();
		// (max - min) + 1) + min
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		int gold = (int)session.getAttribute("gold");
		int goldThisTurn = 0;
		
		ArrayList<String> activities = (ArrayList<String>)session.getAttribute("activityLog");
		if(building.equals("farm")) {
			goldThisTurn = r.nextInt((20 - 10) + 1) + 10;
			activities.add("You entered a farm and earned" + goldThisTurn + formatter.format(now) + ".");
		} else if(building.equals("cave")) {
			goldThisTurn = r.nextInt((10 - 5) + 1) + 5;
			activities.add("You entered a cave and earned" + goldThisTurn + formatter.format(now) + ".");
		} else if(building.equals("house")) {
			goldThisTurn = r.nextInt((5 - 2) + 1) + 2;
			activities.add("You entered a house and earned" + goldThisTurn + formatter.format(now) + ".");
		} else {
			goldThisTurn = r.nextInt((50 + 50) + 1) + -50;
			if(goldThisTurn > 0) {
				activities.add("You entered a casino and earned" + goldThisTurn + formatter.format(now) + ".");
			} else {
				activities.add("You entered a casino and lost" + goldThisTurn + "Ouch" + formatter.format(now) + ".");
			}
			
		}
		int totalGold = gold + goldThisTurn;
		session.setAttribute("gold", totalGold );
		

		return "redirect:/";
	}
}
