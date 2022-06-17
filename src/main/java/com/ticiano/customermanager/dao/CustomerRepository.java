package com.ticiano.customermanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ticiano.customermanager.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	//Automatically Spring JPA will sort it for us using this pattern method name.
	public List<Customer> findAllByOrderByNameAsc();
	
	public List<Customer> findByNameLike(String name);
}
