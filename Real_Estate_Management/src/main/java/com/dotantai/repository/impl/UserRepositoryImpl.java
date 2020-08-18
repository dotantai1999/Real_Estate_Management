
package com.dotantai.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dotantai.entity.BuildingEntity;
import com.dotantai.entity.UserEntity;
import com.dotantai.repository.IUserRepository;

public class UserRepositoryImpl extends JpaRepositoryImpl<UserEntity> implements IUserRepository {

	@Override
	public UserEntity save(UserEntity userEntity) {
		String sql = "insert into user(username, fullname) values(?, ?)";
		Connection connection = null;
		PreparedStatement statement = null;
		/* ResultSet resultSet = null; */
		
		try {
			//Long id = null;
			// connect with DB
			connection = EntityManagerFactory.getConnection();
			
			// dont commit when occur error and callback (transaction)
			connection.setAutoCommit(false);
			
			// create statement
			statement = connection.prepareStatement(sql);
			/*setParameter(statement, parameters);*/
			
			//set param
			statement.setString(1, userEntity.getUserName());
			statement.setString(2, userEntity.getFullName());
					
			// excute query
			statement.executeUpdate();
			
			// get Id from result in resultSet
			/* resultSet = statement.getGeneratedKeys(); */
			
			/*
			 * if (resultSet.next()) { id = resultSet.getLong(1); }
			 */
			
			connection.commit();
			return userEntity;
			
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
				/*
				 * if (resultSet != null) { resultSet.close(); }
				 */
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return new UserEntity();
	}

}
