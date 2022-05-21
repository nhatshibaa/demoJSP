package com.example.demojsp.model;

import com.example.demojsp.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MySQLProductModelTest {

    IProduct iProduct;

    @BeforeEach
    void setUp() {
        iProduct = new MySQLProductModel();
    }

    @Test
    void save() {
        iProduct.save(new Product("p001", "Phở bò", BigDecimal.valueOf(100), "https://image.png", "Siêu ngon"));
    }

    @Test
    void findAll() {
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