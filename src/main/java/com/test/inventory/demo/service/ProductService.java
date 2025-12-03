package com.test.inventory.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import org.springframework.data.domain.*;

import com.test.inventory.demo.exception.GeneralException;
import com.test.inventory.demo.model.Product;
import com.test.inventory.demo.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repo;

    public ProductService(ProductRepository repo){ this.repo = repo; }

    public Page<Product> listProducts(int page){
        Pageable p = PageRequest.of(page, 10, Sort.by("id").ascending());
        return repo.findByQuantityGreaterThan(0,p);
    }

    public Optional<Product> get(Long id){ return repo.findById(id); }

    @Transactional
    public Product create(Product p){ 
    	if(p.getQuantity() <0) { 
    		throw new GeneralException("Quantity is less than zero.");
    	}  	
    	p.setQuantity(Math.max(0, p.getQuantity())); 
    	return repo.save(p);
    }

    @Transactional
    public Product update(Long id, Product input){
        return repo.findById(id).map(existing -> {
            existing.setName(input.getName());
            existing.setQuantity(Math.max(0, input.getQuantity()));
            existing.setDescription(input.getDescription());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Product not found: "+id));
    }

    @Transactional
    public Product adjustQuantity(Long id, int adjustQuantity){
        return repo.findById(id).map(p -> {
            int newQ = Math.max(0, p.getQuantity() + adjustQuantity);
            p.setQuantity(newQ);
            return repo.save(p);
        }).orElseThrow(() -> new RuntimeException("Product not found: "+id));
    }
}
