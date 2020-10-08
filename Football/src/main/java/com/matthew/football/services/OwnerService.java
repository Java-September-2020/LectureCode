package com.matthew.football.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.football.models.Owner;
import com.matthew.football.repositories.OwnerRepository;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository oRepo;
	
	
	public Owner find(Long id) {
		Owner owner = this.oRepo.findById(id).orElse(null);
		return owner;
	}
	
	public List<Owner> allOwners(){
		return this.oRepo.findAll();
	}
	
	
}
