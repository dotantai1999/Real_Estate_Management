package com.dotantai.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dotantai.entity.AssignmentStaffEntity;
import com.dotantai.entity.BuildingEntity;
import com.dotantai.repository.IAssignmentStaffRepository;

public class AssignmentStaffRepositoryImpl extends JpaRepositoryImpl<AssignmentStaffEntity> implements IAssignmentStaffRepository {

	@Override
	public void deleteStaffByBuildingId(Long id) {
		StringBuilder sql = new StringBuilder("delete from assignmentstaff where buildingid = "+id);
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			// connect with DB
			connection = EntityManagerFactory.getConnection();

			// dont commit when occur error and callback (transaction)
			connection.setAutoCommit(false);

			// create statement
			statement = connection.prepareStatement(sql.toString());

			// excute query
			statement.executeUpdate();

			connection.commit();

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
		
	}

	@Override
	public void insertAssignmentStaff(Long buildingId, Long staffId) {
		StringBuilder sql = new StringBuilder("insert into assignmentstaff(buildingid, staffid) values("+buildingId+","+staffId+")");
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			// connect with DB
			connection = EntityManagerFactory.getConnection();

			// dont commit when occur error and callback (transaction)
			connection.setAutoCommit(false);

			// create statement
			statement = connection.prepareStatement(sql.toString());

			// excute query
			statement.executeUpdate();

			connection.commit();

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
		
	}

}
