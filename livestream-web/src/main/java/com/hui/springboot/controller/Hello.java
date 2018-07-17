package com.hui.springboot.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hui.springboot.model.Person;


@RestController
public class Hello {
	
	@PostMapping("/hello")
	String helloSb(@Valid @RequestBody Person p) {
		return "hello " + p.getName() ;
	}
	
	@PostMapping("/hi")
	String hisb( @ModelAttribute Person p ,HttpSession s ) {
		System.out.println("session:" +p);
		System.out.println("pid is " +p.getId());
	
		return "hello " + p.getName();
	}
	
	
	@ModelAttribute
	void setSomething(Model md) {
		
		System.out.println("model attribute is called " +md);
	}
}
