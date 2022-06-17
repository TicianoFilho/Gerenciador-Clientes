package com.ticiano.customermanager.service;

import java.util.List;

import com.ticiano.customermanager.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	public Customer findById(int theId);
	public void save(Customer theCustomer);
	public void deleteById(int theId);
	
	public List<Customer> findAllByOrderByNameAsc();
	public List<Customer> findByNameLike(String name);
}
