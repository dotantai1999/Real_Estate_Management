package com.dotantai.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dotantai.converter.UserConverter;
import com.dotantai.converter.UserRoleConverter;
import com.dotantai.dto.BuildingDTO;
import com.dotantai.dto.UserDTO;
import com.dotantai.dto.UserRoleDTO;
import com.dotantai.entity.UserEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.paging.PageableImpl;
import com.dotantai.repository.IUserRepository;
import com.dotantai.repository.IUserRoleRepository;
import com.dotantai.repository.impl.UserRepositoryImpl;
import com.dotantai.repository.impl.UserRoleRepositoryImpl;
import com.dotantai.service.IUserRoleService;
import com.dotantai.service.IUserService;

public class UserRoleServiceImpl implements IUserRoleService {
	private UserRoleConverter userRoleConverter = new UserRoleConverter();
	private IUserRoleRepository userRoleRepository = new UserRoleRepositoryImpl();
	
	
	
	@Override
	public Long findRoleIdByUserId(Long id) {
		return userRoleRepository.findRoleIdByUserId(id);
	}



	@Override
	public Long insert(UserRoleDTO userRoleDTO) {
		
		return userRoleRepository.insert(userRoleDTO);
	}
	
	

	
}
