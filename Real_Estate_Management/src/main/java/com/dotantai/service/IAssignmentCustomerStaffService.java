package com.dotantai.service;

import java.util.List;

import com.dotantai.dto.AssignmentCustomerStaffDTO;
import com.dotantai.entity.AssignmentCustomerStaffEntity;

public interface IAssignmentCustomerStaffService {
	boolean delete(Long id);
	List<AssignmentCustomerStaffDTO> findByCustomerId(Long id);
}
