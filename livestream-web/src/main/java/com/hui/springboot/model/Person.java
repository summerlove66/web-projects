package com.hui.springboot.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.hui.springboot.validators.NameVal;

public class Person {
	private int id;
	@NotNull
	@Pattern(regexp ="^[\\w|\\d]*?$" ,message="不满足要求")
	@NameVal(contain="ww" ,message="必须要含有ww字段")
	@Size(min=3,max=8)
	private String name;
	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
