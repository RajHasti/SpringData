package com.rajhasti.springdata.transactionmanagement.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankaccount")
public class BankAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int acctno;
	private String firstname;
	private String lastname;
	private int bal;

	public int getAccno() {
		return acctno;
	}

	public void setAccno(int accno) {
		this.acctno = accno;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "BankAccount [accno=" + acctno + ", firstName=" + firstname + ", lastName=" + lastname + ", bal=" + bal
				+ "]";
	}

}
