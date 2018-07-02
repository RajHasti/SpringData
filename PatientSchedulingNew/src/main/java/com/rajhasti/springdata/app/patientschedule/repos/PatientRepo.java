package com.rajhasti.springdata.app.patientschedule.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.app.patientschedule.entities.Patient;

public interface PatientRepo extends CrudRepository<Patient, Long> {

}
