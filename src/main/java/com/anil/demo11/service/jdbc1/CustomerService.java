package com.anil.demo11.service.jdbc1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomer {
	// ??????? should this be here? because every time this is called, there will be new jdbc.
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

	public String getCustomer() {
		
		log.info("Creating Tables");
		
		jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
		
	    // Split up the array of whole names into an array of first/last names
	    List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
	        .map(name -> name.split(" ")).collect(Collectors.toList());
	    // ?????? disect the above and below line ------------------------------------------------------------------------
	    // Use a Java 8 stream to print out each tuple of the list
	    splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

	    // Uses JdbcTemplate's batchUpdate operation to bulk load data
	    jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

	    log.info("Querying for customer records where first_name = 'Josh':");
	    
	    //jdbcTemplate.query("SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
	    //    (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
	    //    .forEach(customer -> log.info(customer.toString()));
		
		
		return null;
	}
}
