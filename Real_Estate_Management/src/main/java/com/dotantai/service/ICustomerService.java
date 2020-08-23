package com.dotantai.service;

import java.util.List;

import com.dotantai.dto.CustomerDTO;
import com.dotantai.dto.UserDTO;
import com.dotantai.entity.CustomerEntity;
import com.dotantai.entity.UserEntity;

public interface ICustomerService {
	
	List<CustomerDTO> findAll(CustomerDTO customerDTO);
	Long insert(CustomerDTO customerDTO);
	void update(CustomerDTO customerDTO);
	boolean delete(Long id);
	CustomerDTO findById(Long id) throws InstantiationException, IllegalAccessException;
}
