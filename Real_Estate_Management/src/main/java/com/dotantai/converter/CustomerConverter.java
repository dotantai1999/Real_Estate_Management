package com.dotantai.converter;

import org.modelmapper.ModelMapper;

import com.dotantai.dto.CustomerDTO;
import com.dotantai.entity.CustomerEntity;

public class CustomerConverter {
	public CustomerDTO convertToDTO(CustomerEntity CustomerEntity) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(CustomerEntity, CustomerDTO.class);

	}

	public CustomerEntity convertToEntity(CustomerDTO CustomerDTO) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(CustomerDTO, CustomerEntity.class);

	}
}
