package com.hui.springboot.service;

import javax.servlet.http.HttpSession;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.hui.springboot.utils.CryptoUntils;
import com.hui.springboot.utils.SendEmail;

@Service
@EnableAsync
public class SendEmailService {
	//存入更改密码时发送验证码
	public final static String changePassKey ="changePassCode";
	//存入 注册时发送的验证码
	public final static String registerKey ="registerCode";
  
  public void sendCode(String toEmail , String subject ,String code) {
	  try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  SendEmail.sendCode(toEmail, subject, code);
  }
  @Async
  public void sendForChangePass(String toEmail  ,HttpSession httpSession ) {
	  String code = CryptoUntils.getRandomString(6, 10);
	  httpSession.setAttribute(changePassKey, code);

	  sendCode(toEmail ,"更改密码" ,code);
	 
  }
  @Async
  public void SendForRegister(String toEmail  ,HttpSession httpSession ) {
	  String code = CryptoUntils.getRandomString(6, 10);
	  httpSession.setAttribute(registerKey, code);
	  sendCode(toEmail ,"注册" ,code);
	 
  }

}
