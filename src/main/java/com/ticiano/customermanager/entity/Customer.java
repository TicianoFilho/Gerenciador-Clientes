package com.ticiano.customermanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "occupation")
	private String occupation;
	
	@Column(name = "study")
	private boolean study;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)	
	private List<Endereco> enderecos;
	
	public Customer() {}


	public Customer(String cpf, String name, String email, String phone, String motherName, String occupation,
			boolean study, List<Endereco> enderecos) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.motherName = motherName;
		this.occupation = occupation;
		this.study = study;
		this.enderecos = enderecos;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public boolean isStudy() {
		return study;
	}

	public void setStudy(boolean study) {
		this.study = study;
	}
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", cpf=" + cpf + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", motherName=" + motherName + ", occupation=" + occupation + ", study=" + study + "]";
	}
	
	
	
	
	
	
}
