package br.com.customer.entities.TO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressTO {

    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;

}
