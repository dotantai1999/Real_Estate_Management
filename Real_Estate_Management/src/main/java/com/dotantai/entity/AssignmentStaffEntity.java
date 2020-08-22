package com.dotantai.entity;

import com.dotantai.annotation.Column;
import com.dotantai.annotation.Entity;
import com.dotantai.annotation.Table;

@Entity
@Table(name = "assignmentstaff")
public class AssignmentStaffEntity {

	@Column(name = "id")
	private Long id;

	@Column(name = "id")
	private Long userId;

	@Column(name = "id")
	private Long buildingId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	
	
	
	

}
