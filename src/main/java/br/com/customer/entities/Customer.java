package br.com.customer.entities;

import br.com.customer.entities.TO.AddressTO;
import br.com.customer.exceptions.CustomerRequiredFieldException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static java.util.Objects.isNull;

@Document(collection = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_id", nullable = false, columnDefinition = "ObjectId")
    private String id;
    @Indexed(unique = true)
    private String document;
    private String name;
    private String phone;
    @Indexed(unique = true)
    private String email;
    private Double earnings;
    private AddressTO address;
    private Boolean active;

    public void validate() {
        if (isNull(name) || name.isEmpty()) {
            throw new CustomerRequiredFieldException("Field \"name\" is required.");
        }
        if (isNull(document) || document.isEmpty()) {
            throw new CustomerRequiredFieldException("Field \"document\" is required.");
        }
        if (isNull(phone) || phone.isEmpty()) {
            throw new CustomerRequiredFieldException("Field \"phone\" is required.");
        }
        if (isNull(email) || email.isEmpty()) {
            throw new CustomerRequiredFieldException("Field \"email\" is required.");
        }
        if (isNull(earnings) || earnings.isNaN()) {
            throw new CustomerRequiredFieldException("Field \"earnings\" is required.");
        }
    }

}
