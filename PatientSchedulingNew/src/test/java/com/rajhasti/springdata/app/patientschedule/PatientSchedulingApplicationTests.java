package com.rajhasti.springdata.app.patientschedule;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.app.patientschedule.entities.Address;
import com.rajhasti.springdata.app.patientschedule.entities.Appointment;
import com.rajhasti.springdata.app.patientschedule.entities.Doctor;
import com.rajhasti.springdata.app.patientschedule.entities.Insurance;
import com.rajhasti.springdata.app.patientschedule.entities.Patient;
import com.rajhasti.springdata.app.patientschedule.repos.AppointmentRepo;
import com.rajhasti.springdata.app.patientschedule.repos.DoctorRepo;
import com.rajhasti.springdata.app.patientschedule.repos.PatientRepo;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PatientSchedulingApplicationTests {
	@Autowired
	DoctorRepo docRepo;

	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	AppointmentRepo appointmentRepo;
	@Test
	public void testCreateDcotor() {

		Doctor doctor = new Doctor();
		doctor.setFirst_name("Raj");
		doctor.setLast_name("Hasti");
		doctor.setSpeciality("All");

		Address address = new Address();
		address.setStreetAddress("870 Elmsbroook Lane");
		address.setCity("Alpharetta");
		address.setState("GA");
		address.setZipcode("30004");
		address.setCountry("US");
		doctor.setAddress(address);
		docRepo.save(doctor);
	}
	
	@Test
	public void testCreatePatient() {
		
		Patient patient = new Patient();
		patient.setFirst_name("Rajini");
		patient.setLast_name("Konduru");
		patient.setPhone("4255168169");
		Insurance insurance = new Insurance();
		insurance.setCopay(25d);
		insurance.setProvider_name("Aetna");
		Doctor doctor = docRepo.findOne((long) 1);
		List<Doctor> doctors=Arrays.asList(doctor);
		patient.setDoctors(doctors);
		patient.setInsurance(insurance);
		Address address = new Address();
		address.setStreetAddress("1824 Riverchase Trail");
		address.setCity("Duluth");
		address.setState("GA");
		address.setZipcode("30096");
		address.setCountry("US");
		patient.setAddress(address);
		patientRepo.save(patient);
				
	}

	@Test
	public void testCreateAppointment() {
		
		Appointment appointment = new Appointment();
		Timestamp appointment_time = new Timestamp(new Date().getTime()); 
		appointment.setAppointment_date(appointment_time);
		appointment.setReason("Emergency::Accident occured");
		appointment.setStarted(true);
		appointment.setPatient(patientRepo.findOne((long) 1));
		appointment.setDoctor(docRepo.findOne((long) 1));
		appointmentRepo.save(appointment);
		
		
	}
}
