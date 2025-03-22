package br.com.customer.requests;

import br.com.customer.entities.Customer;
import lombok.Data;

@Data
public class CustomerRequest {

    private String id;
    private String name;
    private String document;
    private String phone;
    private String email;
    private Double earnings;
    private AddressRequest address;
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
//                .address(address.toEntity())
                .build();
        customer.validate();
        return customer;
    }

    public void toEntity(Customer customer) {
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setEarnings(earnings);
//        customer.setAddress(address.toEntity());
    }

}
