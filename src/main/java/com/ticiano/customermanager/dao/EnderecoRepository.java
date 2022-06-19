package com.ticiano.customermanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ticiano.customermanager.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

	public List<Endereco> findAllByCustomerId(int theId);
}
