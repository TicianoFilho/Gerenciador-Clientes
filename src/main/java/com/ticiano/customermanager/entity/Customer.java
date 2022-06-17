package com.ticiano.customermanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	public Customer() {}

	public Customer(int id, String cpf, String name, String email, String phone, String motherName, String occupation,
			boolean study) {
		this.cpf = cpf;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.motherName = motherName;
		this.occupation = occupation;
		this.study = study;
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

	@Override
	public String toString() {
		return "Customer [id=" + id + ", cpf=" + cpf + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", motherName=" + motherName + ", occupation=" + occupation + ", study=" + study + "]";
	}
	
	
	
	
	
	
}
