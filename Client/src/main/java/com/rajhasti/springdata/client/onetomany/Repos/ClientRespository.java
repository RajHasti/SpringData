package com.rajhasti.springdata.client.onetomany.Repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.client.onetomany.entities.Client;

public interface ClientRespository extends CrudRepository<Client, Long> {

}
