package com.dotantai.converter;

import org.modelmapper.ModelMapper;

import com.dotantai.dto.AssignmentStaffDTO;
import com.dotantai.entity.AssignmentStaffEntity;

public class AssignmentStaffConverter {
	public AssignmentStaffDTO convertToDTO(AssignmentStaffEntity AssignmentStaffEntity) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(AssignmentStaffEntity, AssignmentStaffDTO.class);

	}

	public AssignmentStaffEntity convertToEntity(AssignmentStaffDTO AssignmentStaffDTO) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(AssignmentStaffDTO, AssignmentStaffEntity.class);

	}
}
