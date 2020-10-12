package com.matthew.football.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.football.models.Owner;
import com.matthew.football.models.Team;
import com.matthew.football.repositories.OwnerRepository;
import com.matthew.football.repositories.TeamRepository;

@Service
public class TeamService {
	private TeamRepository tRepo;
	private OwnerRepository oRepo;
	
	public TeamService(TeamRepository repo, OwnerRepository repo2) {
		this.tRepo = repo;
		this.oRepo = repo2;
	}
	
	//GetAll
	public List<Team> getAllTeams(){
		return this.tRepo.findAll();
	}
	
	//GetOne
	public Team getOneTeam(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	//CreateTeam
	public Team createTeam(Team newTeam) {
		return this.tRepo.save(newTeam);
	}
	
	public Team createTeam(String name, String city, int players) {
		Team newTeam = new Team(name, city, players);
		return this.tRepo.save(newTeam);
	}
	
	//Update A Team
	public Team updateTeam(Team updatedTeam) {
		return this.tRepo.save(updatedTeam);
	}
	
	//Delete Team
	public void deleteTeam(Long id) {
		this.tRepo.deleteById(id);
	}
	
	//Add Liker To Team
	public void addLiker(Owner owner, Team team) {
		// Get the list from the Team
		List<Owner> likers = team.getLikers();
		// Add the Owner who likes the team
		likers.add(owner);
		// Update 
		this.tRepo.save(team);
	}
	
	//Save Image Path To Database
	public void uploadPic(Team team, String uploadedURL) {
		team.setLogo(uploadedURL);
		updateTeam(team);
	}

}
