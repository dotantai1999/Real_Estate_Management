package com.dotantai.converter;

import org.modelmapper.ModelMapper;

import com.dotantai.dto.AssignmentCustomerStaffDTO;
import com.dotantai.entity.AssignmentCustomerStaffEntity;

public class AssignmentCustomerStaffConverter {
	public AssignmentCustomerStaffDTO convertToDTO(AssignmentCustomerStaffEntity AssignmentCustomerStaffEntity) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(AssignmentCustomerStaffEntity, AssignmentCustomerStaffDTO.class);

	}

	public AssignmentCustomerStaffEntity convertToEntity(AssignmentCustomerStaffDTO AssignmentCustomerStaffDTO) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(AssignmentCustomerStaffDTO, AssignmentCustomerStaffEntity.class);

	}
}
