package com.test.inventory.demo.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiException {

	private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ApiException(int status, String error, String message, String path) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

}
