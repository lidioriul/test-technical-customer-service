package br.com.customer.responses;

import br.com.customer.entities.TO.AddressTO;
import br.com.customer.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

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
    private AddressTO address;
    private Boolean active;

    public static CustomerResponse fromEntity(@NonNull Customer customer) {
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .document(customer.getDocument())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .earnings(customer.getEarnings())
                .address(customer.getAddress())
                .active(customer.getActive())
                .build();
    }

    public static List<CustomerResponse> fromListEntity(List<Customer> customers) {
        return customers.stream().map(CustomerResponse::fromEntity).toList();
    }

}
