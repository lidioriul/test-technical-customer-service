package br.com.customer.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
