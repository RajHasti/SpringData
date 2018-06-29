package com.rajhasti.springdata.client.onetoone.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.client.onetoone.entities.License;

public interface LicenseRepo extends CrudRepository<License, Long> {

}
