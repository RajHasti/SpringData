package com.rajhasti.springdata.client.Client;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.client.manytomany.entities.Programmer;
import com.rajhasti.springdata.client.manytomany.entities.Project;
import com.rajhasti.springdata.client.manytomany.repos.ProgrammerRepo;
import com.rajhasti.springdata.client.onetomany.Repos.ClientRespository;
import com.rajhasti.springdata.client.onetomany.entities.Address;
import com.rajhasti.springdata.client.onetomany.entities.Client;
import com.rajhasti.springdata.client.onetomany.entities.PhoneNumber;
import com.rajhasti.springdata.client.onetoone.entities.License;
import com.rajhasti.springdata.client.onetoone.entities.Person;
import com.rajhasti.springdata.client.onetoone.repos.LicenseRepo;
import com.rajhasti.springdata.client.onetoone.repos.PersonRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Autowired
	ClientRespository repository;


	@Autowired
	ProgrammerRepo progRepo;
	
	@Autowired
	PersonRepo personRepo;
	
	@Autowired
	LicenseRepo licenseRepo;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreateClient() {

		Client client = new Client();
		client.setName("RajHasti");
		Address address = new Address();
		address.setStreetAddress("870 Elmsbroook Lane");
		address.setCity("Alpharetta");
		address.setState("GA");
		address.setZipcode("30004");
		address.setCountry("US");
		client.setAddress(address);

		PhoneNumber ph1 = new PhoneNumber();
		ph1.setNumber("123456756");
		ph1.setType("Landline");

		PhoneNumber ph2 = new PhoneNumber();
		ph2.setNumber("999999999");
		ph2.setType("Mobile");
		client.addPhoneNumber(ph1);
		client.addPhoneNumber(ph2);

		repository.save(client);

	}

	@Test
	@Transactional
	public void testLoadClient() {

		Client client = repository.findOne(3L);
		System.out.println(client.getName());
		Set<PhoneNumber> numbers = client.getNumbers();
		numbers.forEach(number -> System.out.println(number.getNumber()));

	}
	
	@Test	
	public void testUpdateClient() {

		Client client = repository.findOne(3L);
		client.setName("Vikramaditya");
	
		Set<PhoneNumber> numbers = client.getNumbers();
		numbers.forEach(number -> number.setType("cell"));
		
		repository.save(client);

	}
	
	@Test
	public void testDelete() {
		repository.delete(4L);
	}
	
	@Test
	public void testm2mCreateProgrammer() {
		
		Programmer programmer = new Programmer();
		programmer.setName("RajHasti");
		programmer.setSal(10000);
		HashSet<Project> projects = new HashSet<Project>();
		Project project = new Project();
		project.setName("Spring proj");
		projects.add(project );
		
		programmer.setProjects(projects);
		progRepo.save(programmer);
	}

	@Test
	@Transactional
	public void testm2mLoadProgramer() {

		Programmer prog = progRepo.findOne(1);
		System.out.println(prog);
		System.out.println(prog.getProjects());

	}
	

	@Test
	public void testCreateLicense() {
		
		License license = new License();
		license.setType("CAR");
		license.setValid_from(new Date());
		license.setValid_to(new Date());
		Person person = new Person();
		person.setFirst_name("Raj");
		person.setLast_name("Hasti");
		person.setAge(35);
		license.setPerson(person);
		licenseRepo.save(license);
	}
}
