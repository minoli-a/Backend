package com.test.inventory.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.test.inventory.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page<Product> findByQuantityGreaterThan(int quantity, Pageable pageable);

}
