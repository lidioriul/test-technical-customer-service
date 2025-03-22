package br.com.customer.repositories;

import br.com.customer.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface CustomerRepository {

    Optional<Customer> save(Customer customer);

    Optional<Customer> findAndReplace(Customer customer);

    Optional<Customer> delete(String document);

    Optional<Customer> findByDocument(String document);

    Optional<Customer> findByName(String name);

    Optional<Customer> findByEmail(String email);

    Optional<List<Customer>> findAll();
}
