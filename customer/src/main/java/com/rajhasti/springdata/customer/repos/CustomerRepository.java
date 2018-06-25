package com.rajhasti.springdata.customer.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.customer.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	
	List<Customer> findByName(String name);
	List<Customer> findByNameAndEmail(String name,String Email);

	

	List<Customer> findByEmailLike(String emailLookUp);
	
	List<Customer> findByIdIn(List<Integer> ids);

}
