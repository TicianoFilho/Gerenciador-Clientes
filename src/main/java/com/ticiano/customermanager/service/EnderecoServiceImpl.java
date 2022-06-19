package com.ticiano.customermanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticiano.customermanager.dao.EnderecoRepository;
import com.ticiano.customermanager.entity.Endereco;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Override
	public List<Endereco> findAllByCustomerId(int theId) {
		return enderecoRepository.findAllByCustomerId(theId);
	}

	@Override
	public Endereco findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Endereco theEndereco) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		
	}

}
