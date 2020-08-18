package com.dotantai.entity;

import com.dotantai.annotation.Column;
import com.dotantai.annotation.Entity;
import com.dotantai.annotation.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {
	@Column(name = "username")
	private String userName;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private int status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
