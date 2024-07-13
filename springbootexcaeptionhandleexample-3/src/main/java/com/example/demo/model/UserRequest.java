package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRequest {
	
	@Id
	private int id;
	
	private String uname;
	
	private String pass;
	
	private String startDate;
	
	private String enddate;
	
	private String address;
	
	private long age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", uname=" + uname + ", pass=" + pass + ", startDate=" + startDate
				+ ", enddate=" + enddate + ", address=" + address + ", age=" + age + "]";
	}
	
	

}
