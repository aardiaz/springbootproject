package com.bway.springdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private String userName;
	private String password;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
