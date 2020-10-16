package com.matthew.weddings.controllers;

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

import com.matthew.weddings.models.Wedding;
import com.matthew.weddings.services.UserService;
import com.matthew.weddings.services.WeddingService;

@Controller
@RequestMapping("/weddings")
public class WeddingController {
	@Autowired
	private WeddingService wService;
	@Autowired
	private UserService uService;
	
	
	@GetMapping("")
	public String index(HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		// Maybe check for the presence of USER.
		viewModel.addAttribute("user", this.uService.find(userId));
		viewModel.addAttribute("weddings", this.wService.getWeddings());
		return "weddings/index.jsp";
	}
	
	@GetMapping("/new")
	public String newWedding(HttpSession session, Model viewModel, @ModelAttribute("wedding") Wedding wedding) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user_id", userId);
		return "weddings/new.jsp";
	}
	
	// @RequestMapping("/{id}")
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("wedding", this.wService.getById(id));
		return "weddings/show.jsp";
	}
	
	@PostMapping("")
	public String addWedding(@Valid @ModelAttribute("wedding") Wedding newWedding, BindingResult result, Model viewModel, HttpSession session) {
		System.out.println(newWedding.getDate());
		if(result.hasErrors()) {
			Long userId = (Long)session.getAttribute("user_id");
			viewModel.addAttribute("user_id", userId);
			return "weddings/new.jsp";
		}
		this.wService.createWedding(newWedding);
		return "redirect:/weddings";
	}
}
