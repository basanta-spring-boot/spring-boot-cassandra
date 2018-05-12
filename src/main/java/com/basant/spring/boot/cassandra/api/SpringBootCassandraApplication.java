package com.basant.spring.boot.cassandra.api;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basant.spring.boot.cassandra.api.dao.CustomerRepository;
import com.basant.spring.boot.cassandra.api.model.Customer;

@SpringBootApplication
@RestController
public class SpringBootCassandraApplication {
	@Autowired
	private CustomerRepository repository;

	@PostConstruct
	public void saveCustomer() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(88, "Basant", "Hota", 25));
		customers.add(new Customer(20, "Saroj", "sahoo", 21));
		customers.add(new Customer(87, "Dipti", "Panda", 19));
		customers.add(new Customer(99, "Ravindra", "Patra", 12));
		repository.saveAll(customers);
	}

	@GetMapping("/filterByAge")
	public List<Customer> getCustomerFilterByAge(@RequestParam("age") int age) {
		return repository.findByAgeGreaterThan(age);
	}

	@GetMapping("/filterByName/{name}")
	public List<Customer> getCustomerFilterByName(@PathVariable String name) {
		return repository.findByFirstname(name);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCassandraApplication.class, args);
	}
}
