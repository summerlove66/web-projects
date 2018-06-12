package com.hui.springweb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hui.springweb.service.AddService;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView  add(@RequestParam("t1") int x, @RequestParam("t2") int y,  HttpServletRequest request , HttpServletResponse response) {
//		int x =  Integer.parseInt(request.getParameter("t1"));
//		int y = Integer.parseInt(request.getParameter("t2"));
		System.out.println("I am here" );
		ModelAndView mv = new ModelAndView();
		AddService as = new AddService();
		mv.setViewName("display"); 
		mv.addObject("result", as.add(x , y));
		return mv;
	}
}
