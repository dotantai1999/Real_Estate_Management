package com.dotantai.converter;

import org.modelmapper.ModelMapper;

import com.dotantai.dto.UserRoleDTO;
import com.dotantai.entity.UserRoleEntity;

public class UserRoleConverter {
	public UserRoleDTO convertToDTO(UserRoleEntity UserRoleEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(UserRoleEntity, UserRoleDTO.class);
	}

	public UserRoleEntity convertToEntity(UserRoleDTO UserRoleDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(UserRoleDTO, UserRoleEntity.class);
	}
}
