package com.test.inventory.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.inventory.demo.dto.QuantityDto;
import com.test.inventory.demo.exception.GeneralException;
import com.test.inventory.demo.exception.ProductNotFoundException;
import com.test.inventory.demo.model.Product;
import com.test.inventory.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService productService;
	
    public ProductController(ProductService svc){ 
    	this.productService = svc; 
    }

    @GetMapping
    public Page<Product> list(@RequestParam(defaultValue = "0") int page){
        return productService.listProducts(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id){
        return productService.get(id).map(ResponseEntity::ok)
        		.orElseThrow(() -> new ProductNotFoundException("Product id " + id + " not found"));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p){
        return ResponseEntity.ok(productService.create(p));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p){
        return ResponseEntity.ok(productService.update(id, p));
    }

    @PatchMapping("/{id}/quantity")
    public ResponseEntity<Product> adjust(@PathVariable Long id, @RequestBody QuantityDto dto){
        return ResponseEntity.ok(productService.adjustQuantity(id, dto.getAdjustQuantity()));
    }
}
