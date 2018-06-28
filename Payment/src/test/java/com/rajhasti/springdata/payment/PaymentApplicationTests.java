package com.rajhasti.springdata.payment;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.payment.repos.PaymentRepository;



@SpringBootTest
@RunWith(SpringRunner.class)
public class PaymentApplicationTests {

	@Autowired
	PaymentRepository repository;
}
