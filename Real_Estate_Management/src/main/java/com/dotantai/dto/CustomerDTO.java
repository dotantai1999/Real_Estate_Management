package com.dotantai.dto;

import com.dotantai.annotation.Column;

public class CustomerDTO extends AbstractDTO{
	
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}


