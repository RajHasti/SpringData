package com.rajhasti.springdata.app.patientschedule.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Timestamp appointment_time;
	private boolean started;
	private boolean ended;
	private String reason;
	@ManyToOne
	private Patient patient;
	@ManyToOne
	private Doctor doctor;

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getAppointment_date() {
		return appointment_time;
	}

	public void setAppointment_date(Timestamp appointment_date) {
		this.appointment_time = appointment_date;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isEnded() {
		return ended;
	}

	public void setEnded(boolean ended) {
		this.ended = ended;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointment_date=" + appointment_time + ", started=" + started + ", ended="
				+ ended + ", reason=" + reason + "]";
	}

}
