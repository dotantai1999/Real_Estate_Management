package com.dotantai.repository;

public interface IAssignmentStaffRepository {
	void deleteStaffByBuildingId(Long id);
	void insertAssignmentStaff(Long buildingId, Long staffId);
}
