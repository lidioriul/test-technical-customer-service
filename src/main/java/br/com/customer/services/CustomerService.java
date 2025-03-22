package br.com.customer.services;

import br.com.customer.entities.Customer;
import br.com.customer.exceptions.CustomerNotFoundException;
import br.com.customer.repositories.CustomerRepository;
import br.com.customer.requests.CustomerRequest;
import br.com.customer.responses.CustomerResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse save(@NonNull CustomerRequest customerRequest) {
        Customer customerOnDb = customerRepository.findByDocument(customerRequest.getDocument()).orElse(null);
        Customer savedOnDb;
        if (customerOnDb == null) {
            savedOnDb = customerRepository.save(customerRequest.toEntity()).orElseGet(Customer::new);
        } else {
            savedOnDb = customerRepository.findAndReplace(customerRequest.toEntity()).orElseGet(Customer::new);
        }
        return CustomerResponse.fromEntity(savedOnDb);
    }

    public CustomerResponse save(@NonNull String document,
                                 @NonNull CustomerRequest customerRequest) {
        Customer customerOnDb = customerRepository.findByDocument(document).orElse(null);
        if (customerOnDb == null) {
            return save(customerRequest);
        }
        return CustomerResponse.fromEntity(customerRepository.findAndReplace(customerRequest.toEntity()).orElseGet(Customer::new));
    }

    public CustomerResponse delete(String document) {
        Customer customer = customerRepository.delete(document)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer %s not found.", document)));
        return CustomerResponse.fromEntity(customer);
    }

    public List<CustomerResponse> findAll() {
        return customerRepository.findAll().map(CustomerResponse::fromListEntity).orElse(new ArrayList<>());
    }

    public CustomerResponse findByName(String name) {
        return customerRepository.findByName(name).map(CustomerResponse::fromEntity).orElseThrow(CustomerNotFoundException::new);
    }

    public CustomerResponse findByDocument(@NonNull String document) {
        return customerRepository.findByDocument(document).map(CustomerResponse::fromEntity).orElseThrow(CustomerNotFoundException::new);
    }
}
