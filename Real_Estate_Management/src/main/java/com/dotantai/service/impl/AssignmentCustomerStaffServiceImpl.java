package com.dotantai.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dotantai.converter.AssignmentCustomerStaffConverter;
import com.dotantai.dto.AssignmentCustomerStaffDTO;
import com.dotantai.entity.AssignmentCustomerStaffEntity;
import com.dotantai.repository.IAssignmentCustomerStaffRepository;
import com.dotantai.repository.IAssignmentStaffRepository;
import com.dotantai.repository.impl.AssignmentCustomerStaffRepositoryImpl;
import com.dotantai.repository.impl.AssignmentStaffRepositoryImpl;
import com.dotantai.service.IAssignmentCustomerStaffService;
import com.dotantai.service.IAssignmentStaffService;

public class AssignmentCustomerStaffServiceImpl implements IAssignmentCustomerStaffService {
	private IAssignmentCustomerStaffRepository assignmentCustomerStaffRepository = new AssignmentCustomerStaffRepositoryImpl();
	private AssignmentCustomerStaffConverter assignmentCustomerStaffConverter = new AssignmentCustomerStaffConverter();  
	
	@Override
	public boolean delete(Long id) {
		return assignmentCustomerStaffRepository.delete(id);
	}

	@Override
	public List<AssignmentCustomerStaffDTO> findByCustomerId(Long id) {
		List<AssignmentCustomerStaffEntity> list = assignmentCustomerStaffRepository.findByCustomerId(id);
		List<AssignmentCustomerStaffDTO> result = new ArrayList<>();
		for(AssignmentCustomerStaffEntity item : list) {
			result.add(assignmentCustomerStaffConverter.convertToDTO(item));
		}
		return result;
	}
	
	
	
	  
	
	

}
