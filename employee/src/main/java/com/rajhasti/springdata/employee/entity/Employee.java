package com.rajhasti.springdata.employee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee {
	//@TableGenerator(name="employee_gen",table="id_gen",pkColumnName="gen_name",valueColumnName="gen_val",allocationSize=100)
	@GenericGenerator(name="emp_id",strategy="com.rajhasti.springdata.employee.CustomRandomIDGenerators")
	@GeneratedValue(generator="emp_id")
	@Id
	//@GeneratedValue(strategy=GenerationType.TABLE,generator="employee_gen")
	
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee() {}
	public Employee(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
