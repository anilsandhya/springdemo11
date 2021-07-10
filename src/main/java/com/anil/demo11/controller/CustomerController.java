package com.anil.demo11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;
import com.anil.demo11.domainobject.Customer;
import com.anil.demo11.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired 
	private CustomerService customerService;
		
	@GetMapping("/Customer")
	public String customer() {
		String customer = customerService.getCustomer();
		return customer;
	}
	
}
