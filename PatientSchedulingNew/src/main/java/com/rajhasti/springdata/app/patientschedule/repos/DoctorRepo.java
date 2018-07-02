package com.rajhasti.springdata.app.patientschedule.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.app.patientschedule.entities.Doctor;

public interface DoctorRepo extends CrudRepository<Doctor , Long> {

}
