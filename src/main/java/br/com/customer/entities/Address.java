package br.com.customer.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

//@Document(collection = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    private UUID id;
    private String street;
    private String number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String country;
}
