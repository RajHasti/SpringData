package com.rajhasti.springdata.client.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.client.manytomany.entities.Programmer;

public interface ProgrammerRepo extends CrudRepository<Programmer, Integer> {

}
