package com.example.demojsp.model;

import com.example.demojsp.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlCustomerModelTest {

    ICustomer iCustomer;

    @BeforeEach
    void setUp() {
        iCustomer = new MySqlCustomerModel();
    }

    @Test
    void save() {
        iCustomer.save(new Customer("c001", "nhat", "012312321", "https://image.png", LocalDateTime.of(2004, 10, 10, 10, 10),LocalDateTime.of(2004, 10, 10, 10, 10),LocalDateTime.of(2004, 10, 10, 10, 10),1));
    }

    @Test
    void findALl() {
        List<Customer> list = iCustomer.findAll();
        for (Customer cus :
                list) {
            System.out.println(cus.toString());
        }
    }

    @Test
    void findById() {
        Customer customer = iCustomer.findById("c001");
        assertEquals("nhat", customer.getName());
    }

    @Test
    void update() {
        Customer customer = iCustomer.findById("c001");
        customer.setName("Xuan Van Hung");
        iCustomer.update("c001", customer);
    }

    @Test
    void delete() {
        iCustomer.delete("c001");
        Customer customer = iCustomer.findById("c001");
        assertEquals(null, customer);
    }

}