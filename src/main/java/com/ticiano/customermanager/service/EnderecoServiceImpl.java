package com.ticiano.customermanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticiano.customermanager.dao.EnderecoRepository;
import com.ticiano.customermanager.entity.Endereco;

@Service
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@Override
	public Endereco findById(int theId) {
		
		Optional<Endereco> enderecoOptional = enderecoRepository.findById(theId);
		return (enderecoOptional.isPresent() ? enderecoOptional.get() : null);
	}

	@Override
	public void save(Endereco theEndereco) {
		enderecoRepository.save(theEndereco);
	}

	@Override
	public void deleteById(int theId) {
		enderecoRepository.deleteById(theId);
	}

}
