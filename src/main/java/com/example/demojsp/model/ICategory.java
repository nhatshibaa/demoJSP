package com.example.demojsp.model;

import com.example.demojsp.entity.Category;

import java.util.List;

public interface ICategory {
    Category save(Category category);

    List<Category> findAll();

    Category findById(Integer id);

    Category update(Integer id, Category updateCategory);

    boolean delete(Integer id);
}
