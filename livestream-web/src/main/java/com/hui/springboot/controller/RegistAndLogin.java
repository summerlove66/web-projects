package com.hui.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hui.springboot.model.User;
import com.hui.springboot.projectmodel.Result;
import com.hui.springboot.service.SendEmailService;
import com.hui.springboot.service.UserService;
import com.hui.springboot.utils.ResultUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@RestController
public class RegistAndLogin {

	@Autowired
	private UserService userService;
	@Autowired
	private SendEmailService ses;

	@PostMapping("/register")
	// 前端post json 数据， 如果content-type为 x-www-form-urlencoded 可以用ModelAttribute 参数绑定
	public Result register(@RequestBody User user, HttpSession httpSession) {

		return userService.userRegister(user, httpSession);

	}

	@PostMapping("/user/check/{emailOrUserName}")
	public Result checkUser(@PathVariable String emailOrUserName, @RequestParam String value) {

		return userService.checkUser(emailOrUserName, value);

	}

	@PostMapping("/login")
	public Result Login(@RequestBody User user, HttpSession httpSession) {

		return userService.userLogin(user, httpSession);
	}

	@PostMapping("/sendemail/register")
	public Result sendEmailForRegister(@RequestParam String toEmail, HttpSession httpSession) {

		ses.SendForRegister(toEmail, httpSession);
		return ResultUtil.sucessOrExists;
	}

	@PostMapping("/auth/registercode")
	public Result registerAuth(@RequestParam String email, @RequestParam String code, HttpSession httpSession) {

		return userService.registerCodeAuth(email, code, httpSession);
	}

	@ExceptionHandler(value = MySQLIntegrityConstraintViolationException.class)
	public Result DuplicationUserhandle(Exception e) {
		String exceptionMessage = e.getMessage();
		Result result = new Result();

		result.setCode(0);
		if (exceptionMessage.contains("Duplicate")) {

			result.setMsg("用户名或密码重复");
		} else {
			result.setMsg("未知错误");
		}

		return result;

	}
}
