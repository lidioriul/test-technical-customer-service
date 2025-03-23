package br.com.customer.controllers;

import br.com.customer.exceptions.CustomerNotFoundException;
import br.com.customer.exceptions.CustomerRequiredFieldException;
import br.com.customer.responses.ErrorResponse;
import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = CustomerRequiredFieldException.class)
    public ResponseEntity<?> customerRequiredFieldException(CustomerRequiredFieldException exception) {
        ErrorResponse response = ErrorResponse.builder().code("0001").message(exception.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = MongoWriteException.class)
    public ResponseEntity<?> mongoWriteException(MongoWriteException exception) {
        ErrorResponse response = ErrorResponse.builder().code("0002").message(exception.getMessage()).build();
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity<?> customerNotFoundException(CustomerNotFoundException exception) {
        ErrorResponse response = ErrorResponse.builder().code("0003").message(exception.getMessage()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
