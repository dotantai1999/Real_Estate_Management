package com.dotantai.converter;

import org.modelmapper.ModelMapper;

import com.dotantai.dto.PriorityBuildingListDTO;
import com.dotantai.entity.PriorityBuildingListEntity;

public class PriorityBuildingListConverter {
	public PriorityBuildingListDTO convertToDTO(PriorityBuildingListEntity PriorityBuildingListEntity) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(PriorityBuildingListEntity, PriorityBuildingListDTO.class);

	}

	public PriorityBuildingListEntity convertToEntity(PriorityBuildingListDTO PriorityBuildingListDTO) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(PriorityBuildingListDTO, PriorityBuildingListEntity.class);

	}
}
