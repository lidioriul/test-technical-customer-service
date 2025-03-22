package br.com.customer.requests;

import br.com.customer.entities.Address;

public class AddressRequest {

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;

    public Address toEntity() {
        return Address.builder()
                .street(street)
                .number(number)
                .complement(complement)
                .district(district)
                .city(city)
                .state(state)
                .country(country)
                .build();
    }
}
