
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
import com.dotantai.repository.IUserRepository;

public class UserRepositoryImpl extends JpaRepositoryImpl<UserEntity> implements IUserRepository {
	public List<UserEntity> getStaffByBuildingId(Long id) {
		List<UserEntity> result = new ArrayList<>();
		StringBuilder sql = new StringBuilder("");
		sql.append(
				"select u.id, u.fullname from user u join assignmentstaff a on u.id = a.staffid where a.buildingid = "
						+ id);

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			// connect with DB
			connection = EntityManagerFactory.getConnection();

			// create statement
			statement = connection.prepareStatement(sql.toString());

			// excute query
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				UserEntity userEntity = new UserEntity();
				userEntity.setId(resultSet.getLong(1));
				userEntity.setFullName(resultSet.getString(2));
				result.add(userEntity);
			}

			return result;
		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}

			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

		return new ArrayList<UserEntity>();

	}

}
