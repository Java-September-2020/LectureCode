package com.matthew.fakeinsta.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.matthew.fakeinsta.models.User;
import com.matthew.fakeinsta.repositories.UserRepository;

@Component
public class Validator {
	@Autowired
	private UserRepository uRepo;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
	        User user = (User) target;
	        

	        if(!user.getPassword().equals(user.getConfirmPassword())) {
	        	errors.rejectValue("password", "match", "Passwords do not match!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	        }
	        
	        
	        // Make sure email is unique in the database
	        if(this.uRepo.existsByEmail(user.getEmail())) {
	        	errors.rejectValue("email", "Unique", "Email is already taken, try again!");
	        }
	        
	        
	    }
}
