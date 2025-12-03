package com.test.inventory.demo.exception;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String msg) {
        super(msg);
    }
}
