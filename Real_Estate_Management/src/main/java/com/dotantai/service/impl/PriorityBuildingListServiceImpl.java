package com.dotantai.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;

import com.dotantai.builder.BuildingSearchBuilder;
import com.dotantai.converter.BuildingConverter;
import com.dotantai.dto.BuildingDTO;
import com.dotantai.entity.BuildingEntity;
import com.dotantai.entity.CustomerEntity;
import com.dotantai.entity.PriorityBuildingListEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.repository.IBuildingRepository;
import com.dotantai.repository.IPriorityBuildingListRepository;
import com.dotantai.repository.IUserRepository;
import com.dotantai.repository.impl.BuildingRepositoryImpl;
import com.dotantai.repository.impl.JpaRepositoryImpl;
import com.dotantai.repository.impl.PriorityBuildingListRepositoryImpl;
import com.dotantai.service.IBuildingService;
import com.dotantai.service.IPriorityBuildingListService;

public class PriorityBuildingListServiceImpl extends JpaRepositoryImpl<PriorityBuildingListEntity>
		implements IPriorityBuildingListService {
	private IPriorityBuildingListRepository priorityBuildingListRepository = new PriorityBuildingListRepositoryImpl();
	private IBuildingRepository buildingRepository = new BuildingRepositoryImpl();
	private BuildingConverter buildingConverter = new BuildingConverter();

	@Override
	public List<Long> findPriorityBuildingIdByUserId(Long id) {

		return priorityBuildingListRepository.findPriorityBuildingIdByUserId(id);
	}

	@Override
	public List<BuildingDTO> findPriorityBuildingListByBuildingId(ArrayList<Long> ids) {
		List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		for (Long id : ids) {
			result.add(buildingConverter.convertToDTO(buildingRepository.findById(id)));
		}
		return result;
	}

	public boolean delete(Long buildingId, Long userId) {
		return priorityBuildingListRepository.delete(buildingId,userId);
	}
}
