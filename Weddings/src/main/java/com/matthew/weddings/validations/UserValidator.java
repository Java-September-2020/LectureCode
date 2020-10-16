package com.matthew.weddings.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.matthew.weddings.models.User;
import com.matthew.weddings.repositories.UserRepository;

@Component
public class UserValidator {
	@Autowired
	private UserRepository oRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
	        User user = (User) target;
	        

	        if(!user.getPassword().equals(user.getConfirmPassword())) {
	        	errors.rejectValue("password", "match", "Passwords do not match!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	        }
	        
	        
	        // Make sure email is unique in the database
	        if(this.oRepo.existsByEmail(user.getEmail())) {
	        	errors.rejectValue("email", "Unique", "Email is already taken, try again!");
	        }
	        
	        
	    }
}
