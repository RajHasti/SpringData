package com.rajhasti.springdata.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rajhasti.springdata.product.entity.Product;
import com.rajhasti.springdata.product.repos.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductdataApplicationTests {

	@Autowired
	ProductRepository repository;

	@Autowired
	EntityManager entityManager;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("Iphone");
		product.setDesc("Awesome");
		product.setPrice(1000d);

		repository.save(product);
	}

	@Test
	public void testRead() {

		Product product = repository.findOne(1);
		assertNotNull(product);
		assertEquals("Iphone", product.getName());
		System.out.println(">>>>>>>>>>" + product.getDesc());
	}

	@Test
	public void testUpdate() {

		Product product = repository.findOne(1);
		product.setPrice(1200d);
		repository.save(product);

	}

	@Test
	public void testDelete() {

		if (repository.exists(1)) {
			System.out.println("deleting a product");
			repository.delete(1);
		}
	}

	@Test
	public void testCount() {

		System.out.println("Count ----->" + repository.count());
	}

}
