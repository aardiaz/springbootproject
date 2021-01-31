package com.bway.springdemo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int stdId;
	private String fname;
	private String lname;
	private String gender;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate  dob;
	private String college;
	private String faculty;
	private String semester;
	private String phone;
	private String email;
	private int age;
	private int rollno;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	
	@CreationTimestamp
	private LocalDateTime created;
	@UpdateTimestamp
	private LocalDateTime updated;
	
	private LocalTime  inTime = LocalTime.now();
	
	 
	/**
	 * @return the inTime
	 */
	public LocalTime getInTime() {
		return inTime;
	}
	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(LocalTime inTime) {
		this.inTime = inTime;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	 
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

}
