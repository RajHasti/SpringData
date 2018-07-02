package com.rajhasti.springdata.app.patientschedule.entities;

import javax.persistence.Embeddable;
//Component mapping between Patient and Appointment
@Embeddable
public class Insurance {
	private double copay;
	private String provider_name;
	public double getCopay() {
		return copay;
	}
	public void setCopay(double copay) {
		this.copay = copay;
	}
	public String getProvider_name() {
		return provider_name;
	}
	public void setProvider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	@Override
	public String toString() {
		return "Insurance [copay=" + copay + ", provider_name=" + provider_name + "]";
	}
	public Insurance(double copay, String provider_name) {
		this.copay = copay;
		this.provider_name = provider_name;
	}
	
	public Insurance() {}
}
