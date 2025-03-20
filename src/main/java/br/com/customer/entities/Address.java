package br.com.customer.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class Address {

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;
}
