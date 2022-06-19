package com.ticiano.customermanager.service;

import com.ticiano.customermanager.entity.Endereco;

public interface EnderecoService {
	
	public Endereco findById(int theId);
	public void save(Endereco theEndereco);
	public void deleteById(int theId);
}
