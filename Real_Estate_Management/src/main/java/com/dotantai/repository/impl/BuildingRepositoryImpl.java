
package com.dotantai.repository.impl;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.dotantai.builder.BuildingSearchBuilder;
import com.dotantai.entity.BuildingEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.repository.IBuildingRepository;

public class BuildingRepositoryImpl extends JpaRepositoryImpl<BuildingEntity> implements IBuildingRepository {

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, Pageable pageable,
			BuildingSearchBuilder fieldSearch) {

		StringBuilder sqlSearch = new StringBuilder("SELECT * FROM building A");

		if (StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			sqlSearch.append(" JOIN assignmentstaff ass ON A.id = ass.buildingId");
		}
		
		sqlSearch.append(" WHERE 1=1");
		sqlSearch = this.createSQLfindAll(sqlSearch, params);
		String sqlSpecial = buildSqlSpecial(fieldSearch);
		sqlSearch.append(sqlSpecial);
		

		return this.findAll(sqlSearch, pageable);

	}

	private String buildSqlSpecial(BuildingSearchBuilder fieldSearch) {
		StringBuilder result = new StringBuilder("");
		if (StringUtils.isNotBlank(fieldSearch.getCostRentFrom())) {
			result.append(" AND A.costrent >= " + fieldSearch.getCostRentFrom());
		}

		if (StringUtils.isNotBlank(fieldSearch.getCostRentTo())) {
			result.append(" AND A.costrent <= " + fieldSearch.getCostRentTo());
		}

		if (fieldSearch.getBuildingTypes().length > 0) {
			result.append(" AND (");
			/*
			 * //java 7 int i = 0; for(String item : fieldSearch.getBuildingTypes()) { if(i
			 * == 0) { result.append("A.type LIKE '%"+item+"%' "); } else {
			 * result.append("OR A.type LIKE '%"+item+"%' "); } i++; }
			 */

			// java 8
			result.append("A.type like '%" + fieldSearch.getBuildingTypes()[0] + "%'");
			Arrays.stream(fieldSearch.getBuildingTypes())
					.filter(item -> !item.equals(fieldSearch.getBuildingTypes()[0]))
					.forEach(item -> result.append(" OR A.type LIKE '%" + item + "%'"));

			result.append(")");
		}

		if (StringUtils.isNotBlank(fieldSearch.getAreaRentFrom()) || isNotBlank(fieldSearch.getAreaRentTo())) {
			result.append("AND EXIST (SELECT * FROM rentarea ra WHERE(ra.buildingid = A.id");
			if (fieldSearch.getAreaRentFrom() != null) {
				result.append(" AND ra.value >= " + fieldSearch.getAreaRentFrom());
			}
			if (fieldSearch.getAreaRentTo() != null) {
				result.append(" AND ra.value <= " + fieldSearch.getAreaRentTo());
			}
			result.append("))");
		}
		
		if (StringUtils.isNotBlank(fieldSearch.getStaffId())) {
			result.append(" AND ass.staffId = "+fieldSearch.getStaffId());
		}

		return result.toString();
	}

	@Override
	public BuildingEntity save(BuildingEntity buildingEntity) {
		String sql = "insert into building(name, street, district, ward) values(?, ?, ?, ?)";
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
			statement.setString(1, buildingEntity.getName());
			statement.setString(2, buildingEntity.getStreet());
			statement.setString(3, buildingEntity.getDistrict());
			statement.setString(4, buildingEntity.getWard());
		
			// excute query
			statement.executeUpdate();
			
			// get Id from result in resultSet
			/* resultSet = statement.getGeneratedKeys(); */
			
			/*
			 * if (resultSet.next()) { id = resultSet.getLong(1); }
			 */
			
			connection.commit();
			return buildingEntity;
			
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
		return new BuildingEntity();
		
	}
		


}
