package com.gharelu.customer_service.service;

import com.gharelu.customer_service.model.Customer;
import com.gharelu.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        return repository.findById(id)
                .map(existingCustomer -> {
                    if (customer.getFirstName() != null) {
                        existingCustomer.setFirstName(customer.getFirstName());
                    }
                    if (customer.getLastName() != null) {
                        existingCustomer.setLastName(customer.getLastName());
                    }
                    if (customer.getEmail() != null) {
                        existingCustomer.setEmail(customer.getEmail());
                    }
                    if (customer.getPhoneNumber() != null) {
                        existingCustomer.setPhoneNumber(customer.getPhoneNumber());
                    }
                    return repository.save(existingCustomer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

}

