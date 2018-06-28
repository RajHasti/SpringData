package com.rajhasti.springdata.payment.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="bankcheck")
@PrimaryKeyJoinColumn(name="id")
//@DiscriminatorValue("ch")
public class Check extends Payment{
	private String checknumber;

	public String getCheckNumber() {
		return checknumber;
	}

	public void setCheckNumber(String checknumber) {
		this.checknumber = checknumber;
	}
	
}
