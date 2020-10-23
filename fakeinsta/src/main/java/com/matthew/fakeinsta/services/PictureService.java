package com.matthew.fakeinsta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matthew.fakeinsta.models.Picture;
import com.matthew.fakeinsta.models.User;
import com.matthew.fakeinsta.repositories.PictureRepository;

@Service
public class PictureService {
	@Autowired
	private PictureRepository pRepo;
	
	// Create Image Object, Save To DB
	public void uploadPic(User user, String url, String desc) {
		Picture newPic = new Picture(url, desc, user);
		this.pRepo.save(newPic);
	}
	
	public List<Picture> userPictures(User user){
		return this.pRepo.findAllByUser(user);
	}
}
