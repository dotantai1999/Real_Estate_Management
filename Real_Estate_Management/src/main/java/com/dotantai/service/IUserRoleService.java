package com.dotantai.service;

import java.util.List;

import com.dotantai.dto.UserDTO;
import com.dotantai.dto.UserRoleDTO;
import com.dotantai.entity.UserEntity;
import com.dotantai.repository.IJpaRepository;

public interface IUserRoleService {
	Long findRoleIdByUserId(Long id);
	Long insert(UserRoleDTO userRoleDTO);
}
