package com.dotantai.service;

public interface IAssignmentStaffService {
	void deleteStaffByBuildingId(Long id);
	void insertAssignmentStaff(Long buildingId, Long staffId);
}
