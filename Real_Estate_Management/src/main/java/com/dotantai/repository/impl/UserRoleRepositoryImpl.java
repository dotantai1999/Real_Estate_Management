
package com.dotantai.repository.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dotantai.entity.BuildingEntity;
import com.dotantai.entity.UserEntity;
import com.dotantai.entity.UserRoleEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.paging.PageableImpl;
import com.dotantai.repository.IUserRepository;
import com.dotantai.repository.IUserRoleRepository;

public class UserRoleRepositoryImpl extends JpaRepositoryImpl<UserRoleEntity> implements IUserRoleRepository {

	@Override
	public Long findRoleIdByUserId(Long id) {
		Pageable pageable = new PageableImpl(null,null); 
		StringBuilder sql = new StringBuilder("select * from userrole where id = "+id);
		List<UserRoleEntity> list = findAll(sql, pageable);
		return list.get(0).getRoleId();
	}

	
}
