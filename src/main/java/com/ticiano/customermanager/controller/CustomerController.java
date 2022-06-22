package com.ticiano.customermanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticiano.customermanager.entity.Customer;
import com.ticiano.customermanager.entity.Endereco;
import com.ticiano.customermanager.service.CustomerService;
import com.ticiano.customermanager.service.EnderecoService;
import com.ticiano.customermanager.utils.ProjectInfo;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ProjectInfo projectInfo;
	
	@GetMapping("/list")
	public String findAll(Model model) {
	
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		
		//get this project version which is set in application.properties
		model.addAttribute("version", projectInfo.getSystemVersion());
		
		return "home";
	}
	
	@GetMapping("/form-save")
	public String showCustomerForm(Model model) {
		
		Customer customer = new Customer();
		
		model.addAttribute("customer", customer);
		model.addAttribute("version", projectInfo.getSystemVersion());
		
		return "customer-form";
	}
	
	@GetMapping("/form-update")
	public String formUpdate(@RequestParam("customerId") int theId, Model model) {
		
		Customer customer = customerService.findById(theId);
		
		model.addAttribute("customer", customer);

		model.addAttribute("version", projectInfo.getSystemVersion());
		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer theCostumer) {
		customerService.save(theCostumer);		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int theId) {
		customerService.deleteById(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/por-nome")
	public String findByNameLike(@RequestParam("pesqnome") String theName, Model model) {
		
		List<Customer> customers = customerService.findByNameLike("%" + theName + "%");
		
		model.addAttribute("customers", customers);
		model.addAttribute("version", projectInfo.getSystemVersion());
		
		return "home";
	}
	
	
}
