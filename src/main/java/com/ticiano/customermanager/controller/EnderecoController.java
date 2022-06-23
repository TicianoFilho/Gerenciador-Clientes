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
	public String showForm(@RequestParam("customerId") int customerId, Model model) {
		Endereco endereco = new Endereco();
	
		model.addAttribute("endereco", endereco);
		model.addAttribute("customerId", customerId);
		
		return "endereco-form";
	}
	
	@GetMapping("/form-update")
	public String showEnderecoForm(@RequestParam("enderecoId") int enderecoId, Model model) {
		Endereco endereco = enderecoService.findById(enderecoId);
		
		model.addAttribute("endereco", endereco);
		model.addAttribute("customerId", endereco.getCustomer().getId());
		
		return "endereco-form";
	}
	
	@GetMapping("/get")
	public String findById(@RequestParam(name = "id") int theId, Model model) {
		Endereco endereco = enderecoService.findById(theId);
		model.addAttribute("endereco", endereco);
		
		return "customer-form";
	}
	
	@PostMapping("/save")
	public String save(@RequestParam("customerId") int customerId, @ModelAttribute("endereco") Endereco theEndereco, Model model) {
		Customer customer = customerService.findById(customerId);
		theEndereco.setCustomer(customer);
		
		System.out.println(theEndereco);
		
		enderecoService.save(theEndereco);
		
		model.addAttribute("customerId", customerId);
		
		return "endereco-form";
	}
	
	@GetMapping("delete")
	public String deleteById(@RequestParam(name = "enderecoId") int enderecoId, Model model) {
		Endereco endereco = enderecoService.findById(enderecoId);
		enderecoService.deleteById(endereco.getId());
		return String.format("redirect:/customer/form-update?customerId=%s", endereco.getCustomer().getId());
	}
	

}
