package com.example.demojsp.model;

import com.example.demojsp.entity.Product;

import java.util.List;

public interface IProduct {
    Product save(Product product);

    List<Product> findAll();

    Product findById(String id);

    Product update(String id, Product updateProduct);

    boolean delete(String id);
}
