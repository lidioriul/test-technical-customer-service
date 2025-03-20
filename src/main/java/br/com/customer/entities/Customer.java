package br.com.customer.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "customers")
public class Customer {

    private UUID id;
    private String name;
    private String document;
    private String phone;
    private String email;
    private Double earnings;
    private Address address;
    private Boolean active;

}
