package com.example.msbanking.repository;

import com.example.msbanking.dto.responses.CustomerResponse;
import com.example.msbanking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findAllByActive(Integer active);

    Customer findCustomerByIdAndActive(Long id, Integer active);


    Customer findCustomerByFinAndActive(String fin,Integer active);
}
