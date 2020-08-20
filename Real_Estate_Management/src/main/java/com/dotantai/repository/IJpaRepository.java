package com.dotantai.repository;

import java.util.List;
import java.util.Map;

import com.dotantai.paging.Pageable;

public interface IJpaRepository<T> {

	// getData from table
	List<T> findAll(Map<String,Object> properties, Pageable pageable, Object...objects );
	List<T> findAll(Map<String,Object> properties, Object...objects );
	List<T> findAll(StringBuilder sql, Pageable pageable, Object...objects);
	
	Long insert(Object object);

}
