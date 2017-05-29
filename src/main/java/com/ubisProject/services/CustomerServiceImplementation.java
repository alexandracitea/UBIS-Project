package com.ubisProject.services;

import com.ubisProject.models.Customer;
import com.ubisProject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer save(Customer entity) {
        return this.repository.save(entity);
    }

    @Override
    public List<Customer> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Customer getById(Long customerId) {
        return this.repository.findOne(customerId);
    }

    @Override
    public void delete(Long customerId) {
        this.repository.delete(customerId);
    }
}