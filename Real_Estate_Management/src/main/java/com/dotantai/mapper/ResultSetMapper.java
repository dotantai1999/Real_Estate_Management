package com.dotantai.mapper;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.dotantai.annotation.Column;
import com.dotantai.annotation.Entity;

public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs, Class<T> zClass) {
		List<T> results = new ArrayList<>();
		try {

			if (zClass.isAnnotationPresent(Entity.class)) {
				ResultSetMetaData resultSetMetaData = rs.getMetaData();
				Field[] fields = zClass.getDeclaredFields();

				while (rs.next()) {
					T object = zClass.newInstance();
					for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
						String columnName = resultSetMetaData.getColumnName(i + 1);
						Object columnValue = rs.getObject(i + 1);
						ColumnModel columnModel = new ColumnModel();
						columnModel.setColumnName(columnName);
						columnModel.setColumnValue(columnValue);
						
						convertResultSetToEntity(fields, columnModel, object);

						Class<?> parentClass = zClass.getSuperclass();
						while (parentClass != null) {
							Field[] fieldParents = parentClass.getDeclaredFields();
							convertResultSetToEntity(fieldParents, columnModel, object);
							parentClass = parentClass.getSuperclass();
						}

					}
					results.add(object);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return results;

	}

	public void convertResultSetToEntity(Field[] fields, ColumnModel columnModel, Object... objects) {
		try {
			T object = (T) objects[0];
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class)) {
					Column column = field.getAnnotation(Column.class);
					if (column.name().equals(columnModel.getColumnName()) && columnModel.getColumnValue() != null) {
						BeanUtils.setProperty(object, field.getName(), columnModel.getColumnValue());
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	static class ColumnModel
	{
		private String columnName;
		private Object columnValue;
		
		public String getColumnName() {
			return columnName;
		}
		
		public void setColumnName(String columnName) {
			this.columnName = columnName;
		}
		
		public Object getColumnValue() {
			return columnValue;
		}
		
		public void setColumnValue(Object columnValue) {
			this.columnValue = columnValue;
		}
	
	}
}
