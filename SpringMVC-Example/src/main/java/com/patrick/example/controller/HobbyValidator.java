package com.patrick.example.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HobbyValidator  implements ConstraintValidator<IsValidHobby ,String>{
	private String hobbies;
	
	@Override
	public void initialize(IsValidHobby isvalidHobby) {
		this.hobbies = isvalidHobby.MyValidHobbies();
	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext ctx) {
		// TODO Auto-generated method stub
		if(studentHobby ==null) {
			return false;
		}
		if(studentHobby.toUpperCase().matches(hobbies)) {
			return true;
		}
		
		return false;
	}
	
}
