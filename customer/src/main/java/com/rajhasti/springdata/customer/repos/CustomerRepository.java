package com.rajhasti.springdata.customer.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.customer.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
