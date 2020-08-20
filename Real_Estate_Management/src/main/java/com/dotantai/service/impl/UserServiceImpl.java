package com.dotantai.service.impl;

import com.dotantai.converter.UserConverter;
import com.dotantai.dto.BuildingDTO;
import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;
import com.dotantai.repository.IUserRepository;
import com.dotantai.repository.impl.UserRepositoryImpl;
import com.dotantai.service.IUserService;

public class UserServiceImpl implements IUserService{
	private UserConverter userConverter;
	private IUserRepository userRepository;
	
	public UserServiceImpl() {
		userConverter = new UserConverter();
		userRepository = new UserRepositoryImpl();
	}



	@Override
	public UserDTO save(UserDTO userDTO) {
		UserEntity userEntity = userConverter.convertToEntity(userDTO);
		Long id = userRepository.insert(userEntity);
		return userConverter.convertToDTO(userEntity) ;
	}

}
