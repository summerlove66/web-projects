package com.patrick.example.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class MyExceptionHandle {

	@ExceptionHandler(value= Exception.class)
	public ModelAndView  handleException(Exception e) {
		System.out.println("handle the exception" +e.getMessage());
		ModelAndView mv = new ModelAndView("exception");

		mv.addObject("exceptiondesc" ,"错误信息 " +e.getMessage());
		return mv;
	}
	
	
	@ExceptionHandler(value= IOException.class)
	public ModelAndView  handleIOException(Exception e) {
		System.out.println("handle the IO exception" +e.getMessage());
		ModelAndView mv = new ModelAndView("exception");

		mv.addObject("exceptiondesc" ,"错误信息 " +e.getMessage());
		return mv;
	}
	
	
	
	
	
	
}
