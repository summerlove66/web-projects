package com.hui.springboot.model;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import com.hui.springboot.utils.CryptoUntils;



public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int userId;
	@Size(max=9,min=3 ,message="用户名长度必须在3-9")
	@Pattern(regexp ="^[\\w|\\d]*?$" ,message="必须是数字和字母的组合")
	private String userName;
	private String email;
	private String encryptedPassword;
	private String salt;
	private Date registerTime;
	private int experience;
	private int rank;
	private int money;
	private String rawPassword;
	//private List<UserOrder> userOrders;
	
	public void initUser() {
	
		this.salt = CryptoUntils.getSalt();
		this.encryptedPassword = CryptoUntils.cryptoPasswd(this.rawPassword, this.salt);
		this.registerTime =new Date();
		this.experience = 1;
		this.rank = 1;
		this.money = 0;
	}
	
	
	
	public User() {
		
	}
	
	public int getUserId() {
		return userId;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	

	public String getEncryptedPassword() {
		return encryptedPassword;
	}



	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}



	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public int getExperence() {
		return experience;
	}

	public void setExperence(int experence) {
		this.experience = experence;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getRawPassword() {
		return rawPassword;
	}



	public void setRawPassword(String rawPassword) {
		this.rawPassword = rawPassword;
	}
	

	
}	
