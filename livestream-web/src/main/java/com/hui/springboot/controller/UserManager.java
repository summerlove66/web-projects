package com.hui.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hui.springboot.model.User;
import com.hui.springboot.projectmodel.Result;
import com.hui.springboot.service.SendEmailService;
import com.hui.springboot.service.UserService;
import com.hui.springboot.utils.ResultUtil;

@RestController
public class UserManager {

	@Autowired
	private UserService userService;
	@Autowired
	private SendEmailService ses;
	
	@PostMapping("/sendemail/changepass")
	public Result sendEmailForChangePassword(@RequestParam	String toEmail ,HttpSession httpSession) {
		User user = userService.getUserByEmail(toEmail);
		if( user ==null) {
			return new Result(0,"该邮箱未注册",null);
		}
		ses.sendForChangePass(toEmail, httpSession);
		return ResultUtil.sucessOrExists;
	}
	
	@PostMapping("/auth/changepasscode")
	public Result ChangePasswordAuth(@RequestParam String email ,String code ,@RequestParam String password ,HttpSession httpSession ) {
		
		
		return  userService.changePassAuth(email ,code, password, httpSession);
	}
	

}
