package com.dotantai.converter;

import org.modelmapper.ModelMapper;

import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;

public class UserConverter {
	public UserDTO convertToDTO(UserEntity userEntity) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(userEntity, UserDTO.class);
	}

	public UserEntity convertToEntity(UserDTO userDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(userDTO, UserEntity.class);
	}
}
