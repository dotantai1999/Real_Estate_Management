package com.dotantai.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dotantai.entity.AssignmentCustomerStaffEntity;
import com.dotantai.entity.AssignmentStaffEntity;
import com.dotantai.entity.BuildingEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.paging.PageableImpl;
import com.dotantai.repository.IAssignmentCustomerStaffRepository;
import com.dotantai.repository.IAssignmentStaffRepository;

public class AssignmentCustomerStaffRepositoryImpl extends JpaRepositoryImpl<AssignmentCustomerStaffEntity> implements IAssignmentCustomerStaffRepository {
	public List<AssignmentCustomerStaffEntity> findByCustomerId(Long id) {
		StringBuilder sql = new StringBuilder("");
		sql.append("select * from assignmentcustomerstaff where customerid = "+id);
		
		Pageable pageable = new PageableImpl(null,null);
		return this.findAll(sql, pageable);	
	}
	
	
	

	
	
}
