package br.com.customer.exceptions;

public class CustomerRequiredFieldException extends RuntimeException {

    public CustomerRequiredFieldException(String message) {
        super(message);
    }
}
