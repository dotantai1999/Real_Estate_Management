
package com.dotantai.repository.impl;

import static org.apache.commons.lang.StringUtils.isNotBlank;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			result.append(" AND ass.staffId = " + fieldSearch.getStaffId());
		}

		return result.toString();
	}

	public void update(BuildingEntity buildingEntity) {
		StringBuilder sql = new StringBuilder("");
		sql.append("update building set");
		sql.append(" id = ?, name = ?, numberofbasement = ?, buildingarea = ?, district = ?, ward = ?,");
		sql.append(" street = ?, structure = ?, costrent = ?, costdescription = ?, servicecost = ?,");
		sql.append(" carcost = ?, motorbikecost = ?, overtimecost = ?, electricitycost = ?, deposit = ?,");
		sql.append(" payment = ?, timerent = ?, timedecorator = ?, type = ?, createddate = ?, modifieddate = ?,");
		sql.append(" createdby = ?, modifiedby = ?");
		sql.append(" where id = ?");

		Connection connection = null;
		PreparedStatement statement = null;

		try {
			// Long id = null;
			// connect with DB
			connection = EntityManagerFactory.getConnection();

			// dont commit when occur error and callback (transaction)
			connection.setAutoCommit(false);

			// create statement
			statement = connection.prepareStatement(sql.toString());
			

			// set param
			Field[] fields = (BuildingEntity.class).getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				int index = i + 1;
				Field field = fields[i];
				field.setAccessible(true);
				statement.setObject(index, field.get(buildingEntity));
			}
			statement.setLong(25, (Long)fields[0].get(buildingEntity));
			

			Class<?> parentClass = (BuildingEntity.class).getSuperclass();
			int indexParent = fields.length + 1;
			while (parentClass != null) {
				Field[] fieldParent = parentClass.getDeclaredFields();
				for (int i = 0; i < fieldParent.length; i++) {
					Field field = fieldParent[i];
					field.setAccessible(true);
					statement.setObject(indexParent, field.get(buildingEntity));
					indexParent++;
				}
				parentClass = parentClass.getSuperclass();
			}

			// excute query
			statement.executeUpdate();

			connection.commit();

		} catch (SQLException | IllegalAccessException e) {
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
	public boolean delete(Long id) {
		StringBuilder sql = new StringBuilder("delete from building where id = ?");

		
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			// connect with DB
			connection = EntityManagerFactory.getConnection();

			// dont commit when occur error and callback (transaction)
			connection.setAutoCommit(false);

			// create statement
			statement = connection.prepareStatement(sql.toString());

			// set param
			statement.setLong(1, id);
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

	public BuildingEntity findById(Long id) {
		StringBuilder sql = new StringBuilder("select * from building where id = "+id);
		BuildingEntity buildingEntity = new BuildingEntity();
		
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
				Field[] fields = (BuildingEntity.class).getDeclaredFields();
				Object value;
				
				for(int i = 0; i < fields.length; i++) {
					int index = i + 1;	
					Field field = fields[i];
					field.setAccessible(true);
					value = resultSet.getObject(index);
					field.set(buildingEntity, value);
				}
				
				Class<?> parentClass = (BuildingEntity.class).getSuperclass();
				int indexParent = fields.length + 1;
				while (parentClass != null) {
					Field[] fieldParent = parentClass.getDeclaredFields();
					for (int i = 0; i < fieldParent.length; i++) {
						Field field = fieldParent[i];
						field.setAccessible(true);
						value = resultSet.getObject(indexParent);
						field.set(buildingEntity, value);
						indexParent++;
					}
					parentClass = parentClass.getSuperclass();
				}
			}
			
			return buildingEntity;
			

		} catch (SQLException | IllegalAccessException e) {
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
		
		return new BuildingEntity();
	}
}
