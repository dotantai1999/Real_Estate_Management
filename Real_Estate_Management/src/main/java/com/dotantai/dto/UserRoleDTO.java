package com.dotantai.dto;

import com.dotantai.annotation.Column;

public class UserRoleDTO {

	private Long id;	
	private Long roleId;	
	private Long userId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserRoleDTO(Long roleId, Long userId) {
		super();
		this.roleId = roleId;
		this.userId = userId;
	}
	
	

	

}
