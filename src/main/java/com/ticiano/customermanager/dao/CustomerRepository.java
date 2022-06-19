package com.ticiano.customermanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ticiano.customermanager.entity.Customer;

import net.bytebuddy.implementation.MethodDelegation.WithCustomProperties;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	//Automatically Spring JPA will sort it for us using this pattern method name.
	public List<Customer> findAllByOrderByNameAsc();
	
	public List<Customer> findByNameLike(String name);
	
	@Query("SELECT obj FROM Customer obj JOIN FETCH obj.enderecos")
	public Customer findAllCustomerEndereco();
}
