package com.dotantai.service;

import java.util.ArrayList;
import java.util.List;

import com.dotantai.dto.BuildingDTO;
import com.dotantai.entity.PriorityBuildingListEntity;
import com.dotantai.repository.IJpaRepository;

public interface IPriorityBuildingListService extends IJpaRepository<PriorityBuildingListEntity> {
	List<Long> findPriorityBuildingIdByUserId(Long id);
	List<BuildingDTO> findPriorityBuildingListByBuildingId(ArrayList<Long> ids);
	boolean delete(Long buildingId, Long userId);
}
