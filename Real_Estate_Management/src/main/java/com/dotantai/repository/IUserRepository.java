package com.dotantai.repository;

import java.util.List;

import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;

public interface IUserRepository extends IJpaRepository<UserEntity> {
	List<UserEntity> getStaffByBuildingId(Long id);
	boolean checkAccount(String userName, String password);
}
