package com.hui.springboot.model;

import java.io.Serializable;
import java.util.Date;

public class UserOrder implements Serializable {
	private static long serialVersionUID = 1L;
	private int orderId;
	private int channel; // 平台
	private int orderData; // 订单号
	private Date chargeTime;
	private int money;
	private User user;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		this.channel = channel;
	}
	public int getOrederData() {
		return orderData;
	}
	public void setOrederData(int orederData) {
		this.orderData = orederData;
	}
	public Date getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(Date chargeTime) {
		this.chargeTime = chargeTime;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
