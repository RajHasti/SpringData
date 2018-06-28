package com.rajhasti.springdata.payment.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.payment.entity.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
