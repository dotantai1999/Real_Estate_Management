package com.dotantai.repository;

import java.util.List;

import com.dotantai.dto.UserDTO;
import com.dotantai.entity.PriorityBuildingListEntity;
import com.dotantai.entity.UserEntity;
import com.dotantai.entity.UserRoleEntity;

public interface IPriorityBuildingListRepository extends IJpaRepository<PriorityBuildingListEntity> {
	List<Long> findPriorityBuildingIdByUserId(Long id);
	boolean delete(Long buildingId, Long userId);
	
}
