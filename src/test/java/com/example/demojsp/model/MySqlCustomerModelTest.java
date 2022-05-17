package com.example.demojsp.model;

import com.example.demojsp.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCustomerModelTest {

    ICustomer customer;

    @BeforeEach
    void setUp() {
        customer = new MySqlCustomerModel();
    }

    @Test
    void save() {
        customer.save(new Customer("c001", "nhat", "012312321", "https://image.png", LocalDateTime.of(2004, 10, 10, 10, 10),LocalDateTime.of(2004, 10, 10, 10, 10),LocalDateTime.of(2004, 10, 10, 10, 10),1));
    }

    @Test
    void findALl() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}