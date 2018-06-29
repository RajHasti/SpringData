package com.rajhasti.springdata.transactionmanagement.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.transactionmanagement.entities.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
