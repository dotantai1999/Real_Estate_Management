package com.dotantai.repository;

import com.dotantai.entity.AssignmentStaffEntity;
import com.dotantai.entity.UserEntity;

public interface IAssignmentStaffRepository extends IJpaRepository<AssignmentStaffEntity> {
	void deleteStaffByBuildingId(Long id);
	void insertAssignmentStaff(Long buildingId, Long staffId);
}
