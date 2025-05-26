package com.gharelu.customer_service.service;

import com.gharelu.customer_service.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerById(Long id);
    void deleteCustomer(Long id);
    Customer updateCustomer(Long id, Customer updatedCustomer);
}

