package com.anil.demo11.controller.jdbc1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anil.demo11.domainobject.jdbc1.Customer;
import com.anil.demo11.service.jdbc1.CustomerService;

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
