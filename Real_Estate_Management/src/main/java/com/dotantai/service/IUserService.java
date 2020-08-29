package com.dotantai.service;

import java.util.List;

import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;
import com.dotantai.repository.IJpaRepository;

public interface IUserService {
	UserDTO save(UserDTO userDTO);
	List<UserDTO> getStaffByBuildingId(Long id);
	Long checkAccount(String userName, String password);
	
	List<UserDTO> findAll();
	Long insert(UserDTO userDTO);
	void update(UserDTO userDTO);
	boolean delete(Long id);
	UserDTO findById(Long id) throws InstantiationException, IllegalAccessException;
}
