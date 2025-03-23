package br.com.customer.requests;

import br.com.customer.entities.Customer;
import br.com.customer.entities.TO.AddressTO;
import lombok.Data;

@Data
public class CustomerRequest {

    private String id;
    private String name;
    private String document;
    private String phone;
    private String email;
    private Double earnings;
    private AddressTO address;
    private Boolean active;

    public Customer toEntity() {
        Customer customer = Customer.builder()
                .id(id)
                .name(name)
                .document(document)
                .phone(phone)
                .email(email)
                .earnings(earnings)
                .active(active)
                .address(address)
                .build();
        customer.validate();
        return customer;
    }
}
