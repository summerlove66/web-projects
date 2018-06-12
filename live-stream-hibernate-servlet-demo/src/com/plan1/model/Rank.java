package com.plan1.model;



import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import javax.persistence.Column;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rank {
	@Id @GeneratedValue
	private int rankId;
	private int level;
	private int money;
	@ElementCollection
	@GenericGenerator(name="increment-gen" ,strategy="increment")
	@CollectionId(columns =  @Column(name="UserOrderId") ,generator="increment-gen",type=@Type(type="long"))
	private List<UserOrder> orders = new ArrayList<UserOrder>();
	
	public Rank() {
		
	}
	
	
	public Rank(int level, int money) {
		super();
		this.level = level;
		this.money = money;
		
	}
	
	


	public List<UserOrder> getOrders() {
		return orders;
	}


	public void setOrders(List<UserOrder> orders) {
		this.orders = orders;
	}


	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}




	
	
}
