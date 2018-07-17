package com.hui.springboot.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hui.springboot.mapper.UserMapper;
import com.hui.springboot.model.User;
import com.hui.springboot.projectmodel.Result;
import com.hui.springboot.utils.CryptoUntils;
import com.hui.springboot.utils.ResultUtil;

@Service
public class UserService {

	@Autowired
	public UserMapper userMapper;

	// 存入注册时的邮箱
	public static final String registerMark = "registerEmail";
	// 登陆成功后存入
	public static final String loginedMark = "user";

	public void insertUser(User user) {

		user.initUser();

		userMapper.insertUser(user);
	}

	public List<User> getAllUsers() {

		return userMapper.getAllUsers();
	}

	public User getUserByid(int id) {
		return userMapper.getUserById(id);
	}

	public User getUserByEmail(String email) {
		return userMapper.getUserByEmail(email);
	}

	public User getUserByUserName(String userName) {
		return userMapper.getUserByUserName(userName);
	}

	public User getUserByUserNameAndEmail(User user) {
		return userMapper.getUserByUserNameAndEmail(user);
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public Result userRegister(User user, HttpSession httpSession) {
		// 先判断注册时 是否验证了邮箱
		if (httpSession.getAttribute(registerMark) == null) {
			return ResultUtil.noPermission;
		}
		user.setEmail(httpSession.getAttribute(registerMark).toString());
		insertUser(user);
		httpSession.removeAttribute(registerMark);
		return ResultUtil.sucessOrExists;
	}

	public Result userLogin(User user, HttpSession httpSession) {

		String rawPassword = user.getRawPassword();
		User myUser = getUserByUserNameAndEmail(user);
		if (myUser == null) {
			return ResultUtil.faultOrNull;
		}
		String salt = myUser.getSalt();
		if (CryptoUntils.cryptoPasswd(rawPassword, salt).equals(myUser.getEncryptedPassword())) {
			if (httpSession.getAttribute(loginedMark) == null) {
				httpSession.setAttribute(loginedMark, myUser);
			}
			return ResultUtil.sucessOrExists;
		}

		return ResultUtil.faultOrNull;

	}

	// 未登陆时 找回密码，登陆后可直接用于更改密码
	public Result changePassAuth(String email, String code, String password, HttpSession httpSession) {
		if (httpSession.getAttribute(SendEmailService.changePassKey).equals(code)) {

			User user = getUserByEmail(email);
			user.setEncryptedPassword(CryptoUntils.cryptoPasswd(password, user.getSalt()));
			updateUser(user);

			return ResultUtil.sucessOrExists;
		} else
			return ResultUtil.faultOrNull;

	}

	public Result registerCodeAuth(String email, String code, HttpSession httpSession) {
		if (httpSession.getAttribute(SendEmailService.registerKey).equals(code)) {

			httpSession.setAttribute(registerMark, email);

			return ResultUtil.sucessOrExists;
		} else
			return ResultUtil.faultOrNull;

	}

	public Result checkUser(String emailOrUserName, String value) {

		User user;

		if (emailOrUserName.equals("email")) {

			user = getUserByEmail(value);

		} else if (emailOrUserName.equals("username")) {
			user = getUserByUserName(value);
		} else {
			return ResultUtil.unKnowError;
		}

		if (user != null)
			return ResultUtil.sucessOrExists;
		else
			return ResultUtil.faultOrNull;
	}

}
