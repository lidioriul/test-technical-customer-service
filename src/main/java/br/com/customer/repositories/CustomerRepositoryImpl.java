package br.com.customer.repositories;

import br.com.customer.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndReplaceOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public CustomerRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Optional<Customer> save(Customer customer) {
        return Optional.of(mongoTemplate.save(customer));
    }

    @Override
    public Optional<Customer> findAndReplace(Customer customer) {
        Query query = new Query().addCriteria(Criteria.where("document").is(customer.getDocument()));
        FindAndReplaceOptions options = new FindAndReplaceOptions().upsert().returnNew();
        return Optional.of(mongoTemplate.findAndReplace(query, customer, options, Customer.class, "customer", Customer.class));
    }

    @Override
    public Optional<Customer> delete(String document) {
        Query query = new Query().addCriteria(Criteria.where("document").is(document));
        return Optional.ofNullable(mongoTemplate.findAndRemove(query, Customer.class));
    }

    @Override
    public Optional<Customer> findByDocument(String document) {
        Query query = new Query().addCriteria(Criteria.where("document").is(document));
        return Optional.ofNullable(mongoTemplate.findOne(query, Customer.class));
    }

    @Override
    public Optional<Customer> findByName(String name) {
        Query query = new Query().addCriteria(Criteria.where("name").is(name));
        return Optional.ofNullable(mongoTemplate.findOne(query, Customer.class));
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        Query query = new Query().addCriteria(Criteria.where("email").is(email));
        return Optional.ofNullable(mongoTemplate.findOne(query, Customer.class));
    }

    @Override
    public Optional<List<Customer>> findAll() {
        return Optional.of(mongoTemplate.findAll(Customer.class));
    }
}
