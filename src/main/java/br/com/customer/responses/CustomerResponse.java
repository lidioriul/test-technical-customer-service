package br.com.customer.responses;

import br.com.customer.entities.Address;
import br.com.customer.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerResponse {

    private String id;
    private String name;
    private String document;
    private String phone;
    private String email;
    private Double earnings;
    private Address address;
    private Boolean active;

    public static CustomerResponse fromEntity(@NonNull Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .document(customer.getDocument())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .earnings(customer.getEarnings())
                .active(customer.getActive())
                .build();
    }

    public static List<CustomerResponse> fromListEntity(List<Customer> customers) {
        return customers.stream().map(CustomerResponse::fromEntity).toList();
    }

}
