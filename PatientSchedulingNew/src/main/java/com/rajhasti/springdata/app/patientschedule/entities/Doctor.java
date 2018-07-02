package com.rajhasti.springdata.app.patientschedule.entities;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String first_name;
	private String last_name;
	private String speciality;
	@Embedded
	private Address address;
	@ManyToMany(mappedBy="doctors")
	List<Patient> patients;
	
	@OneToMany
    private List<Appointment> appointments;
	
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", speciality="
				+ speciality + ", address=" + address + "]";
	}
	public Doctor() {}
	public Doctor(Long id, String first_name, String last_name, String speciality, Address address) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.speciality = speciality;
		this.address = address;
	}

}
