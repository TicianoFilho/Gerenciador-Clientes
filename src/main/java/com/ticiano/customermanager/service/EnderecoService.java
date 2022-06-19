package com.ticiano.customermanager.service;

import java.util.List;

import com.ticiano.customermanager.entity.Endereco;

public interface EnderecoService {
	
	public List<Endereco> findAllByCustomerId(int theId);
	public Endereco findById(int theId);
	public void save(Endereco theEndereco);
	public void deleteById(int theId);
}
