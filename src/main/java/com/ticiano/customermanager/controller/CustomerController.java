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
import com.ticiano.customermanager.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String findAll(Model model) {
	
		List<Customer> customers = customerService.findAll();
		model.addAttribute("customers", customers);
		
		return "home";
	}
	
	@GetMapping("/form")
	public String showCustomerForm(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/form-update")
	public String formUpdate(@RequestParam("id") int theId, Model model) {
		
		Customer customer = customerService.findById(theId);
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer theCostumer) {
		customerService.save(theCostumer);		
		return "redirect:/customer/list";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("id") int theId) {
		customerService.deleteById(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("por-nome")
	public String findByNameLike(@RequestParam("pesqnome") String theName, Model model) {
		List<Customer> customers = customerService.findByNameLike("%" + theName + "%");
		model.addAttribute("customers", customers);
		return "home";
	}
	
}
