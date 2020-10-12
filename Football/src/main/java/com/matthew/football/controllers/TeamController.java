package com.matthew.football.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.football.models.Mascot;
import com.matthew.football.models.Owner;
import com.matthew.football.models.Team;
import com.matthew.football.services.MascotService;
import com.matthew.football.services.OwnerService;
import com.matthew.football.services.TeamService;

@Controller
@RequestMapping("/teams")
public class TeamController {
	@Autowired
	private TeamService tService;
	@Autowired
	private MascotService mService;
	@Autowired
	private OwnerService oService;
	
	private static String UPLOADED_FOLDER = "src/main/resources/static/images/";
	
	@RequestMapping("")
	public String index(HttpSession session, Model viewModel) {
		if(session.getAttribute("owner_id") == null){
			return "redirect:/";
		}
		Long ownerId = (Long)session.getAttribute("owner_id");
		System.out.println(ownerId);
		Owner owner = this.oService.find(ownerId);
		List<Team> allTeams = this.tService.getAllTeams();
		viewModel.addAttribute("allTeams", allTeams);
		viewModel.addAttribute("owner", owner);
		return "index.jsp";
	}
	
	@RequestMapping("/add")
	public String addTeam(@ModelAttribute("team") Team team) {
		
		return "add.jsp";
	}
	
	@RequestMapping("/{id}")
	public String showTeam(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("mascot") Mascot mascot, @ModelAttribute("team") Team team, RedirectAttributes redirectAttrs) {
		viewModel.addAttribute("team", this.tService.getOneTeam(id));
		return "show.jsp";
	}
	
	@PostMapping("/upload/{id}")
	public String uploadLogo(@PathVariable("id") Long id, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttrs) {
		Team team = tService.getOneTeam(id);
		// Save the uploaded file to our static folder.
		if(file.isEmpty()) {
			redirectAttrs.addFlashAttribute("message", "Upload field cannot be empty");
			return "redirect:/teams/" + id;
		}
		try { 
			//Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			
			String url = "/images/" + file.getOriginalFilename();
			this.tService.uploadPic(team, url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/teams/" + id;
	}
	
	@PostMapping("/mascot")
	public String addMascot(@ModelAttribute("mascot") Mascot newMascot, BindingResult result, Model viewModel) {
		Long teamId = newMascot.getTeam().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("team", teamId);
			return "show.jsp";
		} else {
			this.mService.create(newMascot);
			return "redirect:/teams/" + teamId;
		}
	}
	
	// Old Way
	@PostMapping("/oldway")
	public String oldAddTeam(@RequestParam("name") String name, @RequestParam("city") String city, @RequestParam("players") int players, RedirectAttributes redirectAttr) {	
		System.out.println(name + city + players);
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("Hey there, you forgot to add a name");
		}
		if(errors.size() > 0) {
			for(String e: errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
		}
		return "redirect:/add";
	}
	
	@PostMapping("/new")
	public String addTeam(@ModelAttribute("team") Team newTeam, Model viewModel, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			this.tService.createTeam(newTeam);
			return "redirect:/teams";
		}
	}
	
	@PostMapping("/{id}")
	public String updateTeam(@Valid @ModelAttribute("team") Team updatedTeam, BindingResult result, @ModelAttribute("mascot") Mascot mascot) {
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
		return "redirect:/teams";
	}
	
	@GetMapping("/like/{id}")
	private String like(@PathVariable("id") Long id, HttpSession session){
		Long ownerId = (Long)session.getAttribute("owner_id");
		Long teamId = id;
		Owner liker = this.oService.find(ownerId);
		Team likedTeam = this.tService.getOneTeam(teamId);
		this.tService.addLiker(liker, likedTeam);
		return "redirect:/teams";
	}
}
