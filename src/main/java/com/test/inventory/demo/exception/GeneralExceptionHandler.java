package com.test.inventory.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiException> handleNotFound(ProductNotFoundException ex, HttpServletRequest request) {
        ApiException error = new ApiException(
                404, "Not Found", ex.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
	@ExceptionHandler(GeneralException.class)
    public ResponseEntity<ApiException> handleBusiness(GeneralException ex, HttpServletRequest request) {
    	ApiException error = new ApiException(
                400, "Bad Request", ex.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
    
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String msg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(f -> f.getField() + ": " + f.getDefaultMessage())
                .findFirst()
                .orElse("Invalid input");

        ApiException error = new ApiException(
                400, "Validation Failed", msg, request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Wrong parameter type
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiException> handleTypeMismatch(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
    	ApiException error = new ApiException(
                400, "Type Mismatch", ex.getMessage(), request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // Fallback - Any other exception
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleGeneric(Exception ex, HttpServletRequest request) {
    	ApiException error = new ApiException(
                500, "Server Error", ex.getMessage(), request.getRequestURI()
        );
        ex.printStackTrace(); // Log stack in console
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
