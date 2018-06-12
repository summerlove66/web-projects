package com.hui.springboot.topic;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Topic {
	
	@Id
	private String id;
	private String name;
	private String content;

	public Topic() {
		
		
	}
	
	
	public Topic(String id, String name, String desc) {
		super();
		this.id = id;
		this.name = name;
		this.content = desc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
