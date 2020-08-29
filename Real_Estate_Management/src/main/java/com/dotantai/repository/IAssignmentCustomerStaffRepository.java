package com.dotantai.repository;

import java.util.List;

import com.dotantai.entity.AssignmentCustomerStaffEntity;
import com.dotantai.entity.AssignmentStaffEntity;
import com.dotantai.entity.UserEntity;

public interface IAssignmentCustomerStaffRepository extends IJpaRepository<AssignmentCustomerStaffEntity> {
	 
	List<AssignmentCustomerStaffEntity> findByCustomerId(Long id);
}
