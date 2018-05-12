package com.basant.spring.boot.cassandra.api.dao;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.basant.spring.boot.cassandra.api.model.Customer;

public interface CustomerRepository extends CassandraRepository<Customer, Integer> {
	@AllowFiltering
	public List<Customer> findByAgeGreaterThan(int age);

	@AllowFiltering
	public List<Customer> findByFirstname(String firstname);

}
