package com.example.demojsp.model;

import com.example.demojsp.entity.Customer;

import java.util.List;

public interface ICustomer {
    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(String id);

    Customer update(String id, Customer updateCustomer);

    boolean delete(String id);
}
