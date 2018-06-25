package com.rajhasti.springdata.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
		//product.setId(1);
		product.setName("Laptop");
		product.setDesc("Dell");
		product.setPrice(2500d);

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

	@Test
	public void testFindByName() {

		List<Product> products = repository.findByName("IWatch");
		products.forEach(p -> System.out.println(p.getPrice()));

		List<Product> products1 = repository.findByName("IWatch");
		products1.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByNameAndDesc() {
		List<Product> products = repository.findByNameAndDesc("tv", "samsung");
		products.forEach(p -> System.out.println(p.getDesc()));
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceGreaterthan() {
		List<Product> products = repository.findByPriceGreaterThan(1000d);
		products.forEach(p -> System.out.println(p.getName()));
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByDesc() {
		List<Product> products = repository.findByDescContains("dell");
		products.forEach(p -> System.out.println(p.getPrice()));
	}

	@Test
	public void testFindByPriceBetween() {
		List<Product> products = repository.findByPriceBetween(1000d, 5000d);
		products.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindByDescLike() {
		List<Product> products = repository.findByDescLike("%de%");
		products.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindByIdIn() {
		List<Product> products = repository.findByIdIn(Arrays.asList(1, 2, 4));
		products.forEach(p -> System.out.println(p.getName()));

	}

	@Test
	public void testFindAllPaging() {
		Pageable pageable = new PageRequest(2, 1);
		Page<Product> results = repository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));
	}

	@Test
	public void testFindAllSorting() {

		repository.findAll(new Sort(Direction.DESC, "name")).forEach(p -> System.out.println(p.getName()));
		repository.findAll(new Sort(Direction.DESC, "name","price")).forEach(p -> System.out.println(p.getName()));

		repository.findAll(new  Sort(new Sort.Order(Direction.DESC, "name"),new Sort.Order("price")) ).forEach(p -> System.out.println(p.getName()));
	}
	@Test
	public void testFindAllPagingAndSorting() {
		Pageable pageable = new PageRequest(1,2,Direction.DESC,"name");
				repository.findAll(pageable).forEach(p -> System.out.println(p.getName()));
	}
	
}
