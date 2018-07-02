package com.rajhasti.springdata.app.patientschedule.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.app.patientschedule.entities.Appointment;

public interface AppointmentRepo extends CrudRepository<Appointment, Long> {

}
