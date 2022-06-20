package com.ticiano.customermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ticiano.customermanager.entity.Customer;
import com.ticiano.customermanager.entity.Endereco;
import com.ticiano.customermanager.service.CustomerService;
import com.ticiano.customermanager.service.EnderecoService;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/form-save")
	public String showForm(@RequestParam(name = "customerid") int customerid, Model model) {
		Endereco endereco = new Endereco();
	
		model.addAttribute("endereco", endereco);
		model.addAttribute("customerid", customerid);
		
		return "endereco-form";
	}
	
	@GetMapping("/get")
	public String findById(@RequestParam(name = "id") int theId, Model model) {
		Endereco endereco = enderecoService.findById(theId);
		model.addAttribute("endereco", endereco);
		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("enderecoCustId") int customerId, @ModelAttribute("endereco") Endereco theEndereco) {
		System.out.println(customerId);
		Customer customer = customerService.findById(customerId);
		theEndereco.setCustomer(customer);
		
		enderecoService.save(theEndereco);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("delete")
	public String deleteById(@RequestParam(name = "id") int theId, Model model) {
		enderecoService.deleteById(theId);
		return "redirect:/customer/form";
	}

}
