package com.rajhasti.springdata.client.Client;

import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.client.onetomany.Repos.ClientRespository;
import com.rajhasti.springdata.client.onetomany.entities.Address;
import com.rajhasti.springdata.client.onetomany.entities.Client;
import com.rajhasti.springdata.client.onetomany.entities.PhoneNumber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientApplicationTests {

	@Autowired
	ClientRespository repository;

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
}
