package com.rajhasti.springdata.product.repos;

import org.springframework.data.repository.CrudRepository;
import com.rajhasti.springdata.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
