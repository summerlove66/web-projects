
package com.patrick.example.domain;


import com.patrick.example.process.IsValidHobby;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Student {
	
	@Pattern(regexp = "^.{3,9}$" ,message= "the length of name must between 3 to 9")
	private String studentName;
	@Size(min=2,max=30 ) @IsValidHobby(MyValidHobbies ="PYTHON|JAVA|LINUX|JS")
	private String studentHobby;
	private Long studentMobile;
	@Past
	private Date studentBdo;
	private List<String> studentSkill;
	private Address studentAddress;
	
	
	public Address getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}
	public Long getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}
	public Date getStudentBdo() {
		return studentBdo;
	}
	public void setStudentBdo(Date studentBdo) {
		this.studentBdo = studentBdo;
	}
	public List<String> getStudentSkill() {
		return studentSkill;
	}
	public void setStudentSkill(List<String> studentSkill) {
		this.studentSkill = studentSkill;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentHobby() {
		return studentHobby;
	}
	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentHobby=" + studentHobby + ", studentMobile="
				+ studentMobile + ", studentBdo=" + studentBdo + ", studentSkill=" + studentSkill + "]";
	}



}
