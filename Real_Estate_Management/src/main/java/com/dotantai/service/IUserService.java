package com.dotantai.service;

import java.util.List;

import com.dotantai.dto.UserDTO;
import com.dotantai.entity.UserEntity;

public interface IUserService {
	UserDTO save(UserDTO userDTO);
	List<UserDTO> getStaffByBuildingId(Long id);
	boolean checkAccount(String userName, String password);
}
