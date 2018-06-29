package com.rajhasti.springdata.employee.repos;

import org.springframework.data.repository.CrudRepository;

import com.rajhasti.springdata.employee.entity.Employee;

public interface EmployeeRespository extends CrudRepository<Employee, Long> {

}
