package com.plan1.model;

import java.util.Date;

import javax.persistence.Embeddable;


@Embeddable
public class UserOrder {
	
	
	private int channel;
	private Date chargeTime;
	private int money;
	
	
	public UserOrder() {
		super();
	}


	public UserOrder( int channel,  int money) {
		super();
	
		this.channel = channel;
		this.chargeTime = new Date();
		this.money = money;
	}

	
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public Date getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(Date date) {
		this.chargeTime = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
}
