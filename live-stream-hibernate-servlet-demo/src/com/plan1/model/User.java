package com.plan1.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.plan1.utils.DateTimeConverter;

@Entity

@NamedQueries({
	@NamedQuery(name="User.isRight" ,query = "from User where email=? or userName =?"),
	@NamedQuery(name="User.isExist",query ="from User where email=? and userName =?")})
	@NamedQuery(name="User.toActivated" ,query="from User where  email=? and activateCode=?")
public class User {
	@Id
	@GeneratedValue
	private int userId;
	private String userName;
	private String email;
	private String password;
	private String salt;
	private Date registerTime; 
	private boolean isActivated;
	private String  activateCode;
	@OneToOne(cascade=CascadeType.PERSIST )
	private Rank rank;
	
	public User() {
	
	}

	public User(String userName, String email, String password ,String salt) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.registerTime =new Date();
		this.isActivated =false;
		this.salt =salt;
		this.activateCode = UUID.randomUUID().toString();
	}
	
	
	

	public String getActivateCode() {
		return activateCode;
	}

	public void setActivateCode(String activateCode) {
		this.activateCode = activateCode;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getUserId() {
		return userId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}


		
}
