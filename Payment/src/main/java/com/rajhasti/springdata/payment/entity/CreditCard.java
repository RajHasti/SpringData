package com.rajhasti.springdata.payment.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="card")
@PrimaryKeyJoinColumn(name="id")
//@DiscriminatorValue("cc")
public class CreditCard extends Payment{

		private String cardnumber;

		public String getCardNumber() {
			return cardnumber;
		}

		public void setCardNumber(String cardnumber) {
			this.cardnumber = cardnumber;
		}
		
		
		
}
