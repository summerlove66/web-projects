package com.patrick.example.process;

import com.patrick.example.process.HobbyValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint( validatedBy = HobbyValidator.class)
@Target({ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {

	String message() default "please provide a valid Hobby :" +
	"accpted hobbies are -Java ,Python,Linux(choose anyone )";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	String MyValidHobbies();
	
}
