package com.bway.springdemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import net.bytebuddy.implementation.bind.annotation.Empty;

@Entity
public class Address {

	@Id
	@GeneratedValue
	private int addressId;
	private String country;
	private String city;
	private String state;
	private String zipCode;
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
}
