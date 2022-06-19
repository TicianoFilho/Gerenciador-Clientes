package com.ticiano.customermanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticiano.customermanager.dao.CustomerRepository;
import com.ticiano.customermanager.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findById(int theId) {
		
		Customer customer = null;
		
		Optional<Customer> customerOptional = customerRepository.findById(theId);
		if(customerOptional.isPresent()) {
			customer = customerOptional.get();
		} else {
			throw new RuntimeException("NÃO FOI ENCONTRADO NADA");
		}
		
		return customer;
	}

	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		customerRepository.deleteById(theId);
	}

	@Override
	public List<Customer> findAllByOrderByNameAsc() {
		return customerRepository.findAllByOrderByNameAsc();
	}

	@Override
	public List<Customer> findByNameLike(String theName) {
		return customerRepository.findByNameLike(theName);
	}

	@Override
	public Customer findAllCustomerEndereco() {
		return customerRepository.findAllCustomerEndereco();
	}

}
