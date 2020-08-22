package com.dotantai.service.impl;

import com.dotantai.repository.IAssignmentStaffRepository;
import com.dotantai.repository.impl.AssignmentStaffRepositoryImpl;
import com.dotantai.service.IAssignmentStaffService;

public class AssignmentStaffServiceImpl implements IAssignmentStaffService {
	private IAssignmentStaffRepository assignmentStaffRepository = new AssignmentStaffRepositoryImpl();  
	
	@Override
	public void deleteStaffByBuildingId(Long id) {
		assignmentStaffRepository.deleteStaffByBuildingId(id);

	}

	@Override
	public void insertAssignmentStaff(Long buildingId, Long staffId) {
		assignmentStaffRepository.insertAssignmentStaff(buildingId, staffId);
	}
	
	

}
