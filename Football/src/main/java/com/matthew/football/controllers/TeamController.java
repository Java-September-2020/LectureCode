package com.matthew.football.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.football.models.Mascot;
import com.matthew.football.models.Team;
import com.matthew.football.services.MascotService;
import com.matthew.football.services.TeamService;

@Controller
public class TeamController {
	@Autowired
	private TeamService tService;
	@Autowired
	private MascotService mService;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Team> allTeams = this.tService.getAllTeams();
		viewModel.addAttribute("allTeams", allTeams);
		return "index.jsp";
	}
	
	@RequestMapping("/add")
	public String addTeam(@ModelAttribute("team") Team team) {
		
		return "add.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showTeam(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("mascot") Mascot mascot, @ModelAttribute("team") Team team) {
		viewModel.addAttribute("team", this.tService.getOneTeam(id));
		return "show.jsp";
	}
	
	@PostMapping("/mascot")
	public String addMascot(@ModelAttribute("mascot") Mascot newMascot, BindingResult result, Model viewModel) {
		Long teamId = newMascot.getTeam().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("team", teamId);
			return "show.jsp";
		} else {
			this.mService.create(newMascot);
			return "redirect:/" + teamId;
		}
	}
	
	@PostMapping("/team")
	public String addTeam(@ModelAttribute("team") Team newTeam, BindingResult result) {	
		if(result.hasErrors()) {
			return "add.jsp";
		} else {
			this.tService.createTeam(newTeam);
			return "redirect:/";
		}
	}
	
	@PostMapping("/{id}")
	public String updateTeam(@ModelAttribute("team") Team updatedTeam, BindingResult result) {
		if(result.hasErrors()) {
			return "show.jsp";
		} else {
			this.tService.updateTeam(updatedTeam);
			return "redirect:/";
		}
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTeam(@PathVariable("id") Long id) {
		this.tService.deleteTeam(id);
		return "redirect:/";
	}
}
