package com.rajhasti.springdata.payment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@DiscriminatorColumn(name="pmode",discriminatorType=DiscriminatorType.STRING)
public abstract class Payment {
 @Id
 
 private long id;
 private double amount;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Payment [id=" + id + ", amount=" + amount + "]";
}
public Payment() {}
public Payment(long id, double amount) {
	this.id = id;
	this.amount = amount;
}
 
 
}
