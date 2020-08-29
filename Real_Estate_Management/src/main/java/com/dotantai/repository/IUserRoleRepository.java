package com.dotantai.repository;

import java.util.List;

import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;
import com.dotantai.entity.UserRoleEntity;

public interface IUserRoleRepository extends IJpaRepository<UserRoleEntity> {
	Long findRoleIdByUserId(Long id);
	
}
