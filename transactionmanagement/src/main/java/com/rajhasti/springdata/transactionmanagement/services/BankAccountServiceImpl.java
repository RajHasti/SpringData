package com.rajhasti.springdata.transactionmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rajhasti.springdata.transactionmanagement.entities.BankAccount;
import com.rajhasti.springdata.transactionmanagement.repos.BankAccountRepository;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepository repository;

	@Override
	@Transactional
	public void transfer(int amount)   {

		BankAccount rajAcct = repository.findOne(1);
		rajAcct.setBal(rajAcct.getBal() - amount);
		repository.save(rajAcct);
        if(true)
        	throw new RuntimeException();
		
        BankAccount vikAcct = repository.findOne(2);
		vikAcct.setBal(vikAcct.getBal() + amount);
		repository.save(vikAcct);

	}

}
