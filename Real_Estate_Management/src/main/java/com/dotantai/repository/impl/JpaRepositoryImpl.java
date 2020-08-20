package com.dotantai.repository.impl;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.dotantai.annotation.Entity;
import com.dotantai.annotation.Table;
import com.dotantai.mapper.ResultSetMapper;
import com.dotantai.paging.Pageable;
import com.dotantai.repository.IJpaRepository;

public class JpaRepositoryImpl<T> implements IJpaRepository<T> {
	private Class<T> zClass;

	public JpaRepositoryImpl() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public List<T> findAll(Map<String, Object> properties, Pageable pageable, Object... where) {
		String tableName = "";
		if (zClass.isAnnotationPresent((Class<? extends Annotation>) Entity.class)
				&& zClass.isAnnotationPresent((Class<? extends Annotation>) Table.class)) {
			Table tableClass = zClass.getAnnotation(Table.class);
			tableName = tableClass.name();
		}

		StringBuilder sql = new StringBuilder("select * from " + tableName+" A");
		sql = sql.append(" where 1=1");
		sql = createSQLfindAll(sql, properties);
		if (where != null && where.length == 1) {
			sql.append(where[0]);
		}

		if(pageable.getOffset() != null && pageable.getLimit() != null) {
			sql.append(" limit " + pageable.getOffset() + "," + pageable.getLimit());
		}
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

		Connection connection = null;
		// PreparedStatement statement = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = EntityManagerFactory.getConnection();
			// statement = connection.prepareStatement(sql.toString());
			// resultSet = statement.executeQuery();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());

			return resultSetMapper.mapRow(resultSet, this.zClass);

		} catch (SQLException e) {
			return new ArrayList<>();
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e) {
				return new ArrayList<>();
			}

		}

	}

	@Override
	public List<T> findAll(Map<String, Object> properties, Object... where) {
		// get table name to write query statement
		String tableName = "";
		if (zClass.isAnnotationPresent((Class<? extends Annotation>) Entity.class)
				&& zClass.isAnnotationPresent((Class<? extends Annotation>) Table.class)) {
			Table tableClass = zClass.getAnnotation(Table.class);
			tableName = tableClass.name();
		}

		StringBuilder sql = new StringBuilder("select * from " + tableName + " A");
		sql.append(" WHERE 1=1");
		sql = createSQLfindAll(sql, properties);

		if (where != null && where.length == 1) {
			sql.append(where[0]);
		}

		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

		Connection connection = null;
		// PreparedStatement statement = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = EntityManagerFactory.getConnection();
			// statement = connection.prepareStatement(sql.toString());
			// resultSet = statement.executeQuery();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());

			return resultSetMapper.mapRow(resultSet, this.zClass);

		} catch (SQLException e) {
			return new ArrayList<>();
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e) {
				return new ArrayList<>();
			}

		}

	}

	protected StringBuilder createSQLfindAll(StringBuilder where, Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			String[] keys = new String[params.size()];
			Object[] values = new Object[params.size()];

			int i = 0;
			for (Entry<String, Object> s : params.entrySet()) {
				keys[i] = s.getKey();
				values[i] = s.getValue();
				i++;
			}

			for (i = 0; i < keys.length; i++) {
				if (values[i] instanceof String && StringUtils.isNotBlank(values[i].toString())) {
					where.append(" AND LOWER(A." + keys[i].toString() + ") LIKE '%" + values[i].toString() + "%' ");

				} else if (values[i] instanceof Integer && values[i] != null) {
					where.append(" AND LOWER(A." + keys[i].toString() + ") = " + values[i].toString() + " ");

				} else if (values[i] instanceof Long && values[i] != null) {
					where.append(" AND LOWER(A." + keys[i].toString() + ") = " + values[i].toString() + " ");
				}

			}

		}
		return where;
	}

	@Override
	public List<T> findAll(StringBuilder sqlSearch, Pageable pageable, Object... objects) {
		StringBuilder sql = new StringBuilder(sqlSearch);
		if(pageable.getOffset() != null && pageable.getLimit() != null) {
			sql.append(" limit " + pageable.getOffset() + "," + pageable.getLimit());
		}
		
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

		Connection connection = null;
		// PreparedStatement statement = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = EntityManagerFactory.getConnection();
			// statement = connection.prepareStatement(sql.toString());
			// resultSet = statement.executeQuery();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());

			return resultSetMapper.mapRow(resultSet, this.zClass);

		} catch (SQLException e) {
			return new ArrayList<>();
		} finally {

			try {
				if (connection != null) {
					connection.close();
				}

				if (statement != null) {
					statement.close();
				}

				if (resultSet != null) {
					resultSet.close();
				}

			} catch (SQLException e) {
				return new ArrayList<>();
			}

		}

	}

}
