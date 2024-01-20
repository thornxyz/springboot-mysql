package org.test.springtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.test.springtest.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
