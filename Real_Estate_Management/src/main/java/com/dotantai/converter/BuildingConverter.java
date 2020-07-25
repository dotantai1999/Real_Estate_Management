package com.dotantai.converter;

import org.modelmapper.ModelMapper;

import com.dotantai.dto.BuildingDTO;
import com.dotantai.entity.BuildingEntity;

public class BuildingConverter {
	public BuildingDTO convertToDTO(BuildingEntity buildingEntity)
	{
		ModelMapper modelMapper = new ModelMapper();
		
		return modelMapper.map(buildingEntity,BuildingDTO.class);
		
	}
}

