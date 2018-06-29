package com.rajhasti.springdata.payment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.payment.entity.Check;
import com.rajhasti.springdata.payment.entity.CreditCard;
import com.rajhasti.springdata.payment.repos.PaymentRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentApplicationTests {

	@Autowired
	PaymentRepository repository;
	
	@Test
	public void contextLoads() {}
	
	@Test
	public void createPaymentByCard() {
		
		CreditCard cc = new CreditCard();
	    cc.setId(123);
		cc.setAmount(1000);
		cc.setCardNumber("1234567890");
		repository.save(cc);
	}
	@Test
	public void createPaymentByCheck() {
		
		Check ch = new Check();
		ch.setId(111);
		ch.setAmount(1000);
		ch.setCheckNumber("1234567890");
		repository.save(ch);
	}
}
