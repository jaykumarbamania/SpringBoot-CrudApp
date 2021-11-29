package com.neosoft.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long stid;
	
	private String stname;
	private double stmarks;
	private String subject;
	
	public long getStid() {
		return stid;
	}
	public void setStid(long stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public double getStmarks() {
		return stmarks;
	}
	public void setStmarks(double stmarks) {
		this.stmarks = stmarks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Student [stid=" + stid + ", stname=" + stname + ", stmarks=" + stmarks + ", subject=" + subject + "]";
	}
	
	
	
}
