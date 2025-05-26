package com.gharelu.customer_service.repository;

import com.gharelu.customer_service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}


