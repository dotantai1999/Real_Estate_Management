package com.dotantai.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dotantai.converter.UserConverter;
import com.dotantai.dto.BuildingDTO;
import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;
import com.dotantai.repository.IUserRepository;
import com.dotantai.repository.impl.UserRepositoryImpl;
import com.dotantai.service.IUserService;

public class UserServiceImpl implements IUserService {
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
		return userConverter.convertToDTO(userEntity);
	}

	public List<UserDTO> getStaffByBuildingId(Long id) {
		List<UserDTO> result1 = new ArrayList<>();
		List<UserEntity> result = userRepository.getStaffByBuildingId(id);
		for (UserEntity item : result) {
			result1.add(userConverter.convertToDTO(item));
		}

		return result1;
	}

	@Override
	public boolean checkAccount(String userName, String password) {
		return userRepository.checkAccount(userName, password);

	}

}
