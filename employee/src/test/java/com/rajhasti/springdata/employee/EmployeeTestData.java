package com.rajhasti.springdata.employee;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.employee.entity.Employee;
import com.rajhasti.springdata.employee.repos.EmployeeRespository;

@SpringBootTest

@RunWith(SpringRunner.class)
public class EmployeeTestData {
	@Autowired
	EmployeeRespository repository;

	@Test
	public void contextloads() {
	}

	@Test
	public void createEmployee() {
           Employee emp = new Employee();
         //  emp.setId(123L);
           emp.setName("Raj");
           repository.save(emp);
           
	}
}
