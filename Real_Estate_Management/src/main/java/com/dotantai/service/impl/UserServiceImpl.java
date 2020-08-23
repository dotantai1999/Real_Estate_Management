package com.dotantai.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dotantai.converter.UserConverter;
import com.dotantai.dto.BuildingDTO;
import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.paging.PageableImpl;
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

	@Override
	public List<UserDTO> findAll() {
		Pageable pageable = new PageableImpl(null, null);
		StringBuilder sql = new StringBuilder();
		sql.append("select * from user");
		List<UserEntity> listEntity = userRepository.findAll(sql, pageable);
		List<UserDTO> listDTO = new ArrayList<>();
		for (UserEntity item : listEntity) {
			listDTO.add(userConverter.convertToDTO(item));
		}
		return listDTO;
	}

	@Override
	public Long insert(UserDTO userDTO) {
		return userRepository.insert(userConverter.convertToEntity(userDTO));
	}

	@Override
	public void update(UserDTO userDTO) {
		userRepository.update(userConverter.convertToEntity(userDTO));
	}

	@Override
	public boolean delete(Long id) {
		return userRepository.delete(id);
	}

	@Override
	public UserEntity findById(Long id) throws InstantiationException, IllegalAccessException {
		
		return userRepository.findById(id);
	}
}
