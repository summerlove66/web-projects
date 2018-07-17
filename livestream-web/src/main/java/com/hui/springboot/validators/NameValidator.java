package com.hui.springboot.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator  implements ConstraintValidator<NameVal ,String>{
	private String contain;
	private String notContain;
	@Override
	public void initialize(NameVal nav) {
		this.contain = nav.contain();
		this.notContain = nav.notContain();
	}
	@Override
	public boolean isValid(String data, ConstraintValidatorContext ctx) {
		// TODO Auto-generated method stub
		if(data==null) {
			return false;
		}
		if(data.contains(contain) && ! data.contains(notContain)) {
			return true;
		}
		
		return false;
	}
	
}
