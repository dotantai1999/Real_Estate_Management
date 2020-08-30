
package com.dotantai.repository.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dotantai.entity.PriorityBuildingListEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.paging.PageableImpl;
import com.dotantai.repository.IPriorityBuildingListRepository;

public class PriorityBuildingListRepositoryImpl extends JpaRepositoryImpl<PriorityBuildingListEntity> implements IPriorityBuildingListRepository {
	public List<Long> findPriorityBuildingIdByUserId(Long userId) {
		Pageable pageable = new PageableImpl(null,null);
		StringBuilder sql = new StringBuilder("select * from prioritybuildinglist where userid = "+userId);
		List<PriorityBuildingListEntity> list = findAll(sql, pageable);
		ArrayList<Long> listResult = new ArrayList<>();
		for(PriorityBuildingListEntity item : list) {
			listResult.add(item.getBuildingId());
		}
		return listResult;
	}

	@Override
	public boolean delete(Long buildingId, Long userId) {
		
		StringBuilder sql = new StringBuilder("delete from prioritybuildinglist where buildingid = "+buildingId);
		sql.append(" and userid = "+userId);

		
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
			return true;

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
		return false;
	}	
	
	



	
}
