package com.dotantai.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.dotantai.converter.CustomerConverter;
import com.dotantai.dto.CustomerDTO;
import com.dotantai.entity.CustomerEntity;
import com.dotantai.paging.Pageable;
import com.dotantai.paging.PageableImpl;
import com.dotantai.repository.ICustomerRepository;
import com.dotantai.repository.impl.CustomerRepositoryImpl;
import com.dotantai.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
	private CustomerConverter customerConverter = new CustomerConverter();
	@Override
	public List<CustomerDTO> findAll(CustomerDTO customerDTO) {
		Pageable pageable = new PageableImpl(null, null);
		StringBuilder sql = new StringBuilder();
		sql.append("select * from customer where name like '%"+customerDTO.getName());
		sql.append("%' and phonenumber like '%"+customerDTO.getPhoneNumber());
		sql.append("%' and email like '%"+customerDTO.getEmail()+"%'");
		sql = new StringBuilder(sql.toString().replace("null", ""));
				
		
		List<CustomerEntity> listEntity = customerRepository.findAll(sql, pageable);
		List<CustomerDTO> listDTO = new ArrayList<>();
		for (CustomerEntity item : listEntity) {
			listDTO.add(customerConverter.convertToDTO(item));
		}
		return listDTO;
	}
	@Override
	public Long insert(CustomerDTO customerDTO) {
		return customerRepository.insert(customerConverter.convertToEntity(customerDTO));
	}
	@Override
	public void update(CustomerDTO customerDTO) {
		customerRepository.update(customerConverter.convertToEntity(customerDTO));
	}
	@Override
	public boolean delete(Long id) {
		return customerRepository.delete(id);
	}
	@Override
	public CustomerDTO findById(Long id) throws InstantiationException, IllegalAccessException {
		return customerConverter.convertToDTO(customerRepository.findById(id));		
	}
	
	
}
