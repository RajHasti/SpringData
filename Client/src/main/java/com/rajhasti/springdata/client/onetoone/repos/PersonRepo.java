package com.rajhasti.springdata.client.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.client.onetoone.entities.Person;

public interface PersonRepo extends CrudRepository<Person, Long> {

}
