package com.example.demojsp.model;

import com.example.demojsp.entity.Category;
import com.example.demojsp.entity.Customer;
import com.example.demojsp.entity.enums.CategoryStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MySQLCategoryModelTest {

    private ICategory iCategory;

    @BeforeEach
    void setUp() {
        iCategory = new MySQLCategoryModel();
    }

    @Test
    void save() {
        Category category = new Category();
        category.setName("Quần");
        iCategory.save(category);
        Category category1 = new Category();
        category1.setName("Áo");
        iCategory.save(category1);
        Category category2 = new Category();
        category2.setName("Giày");
        iCategory.save(category2);
        Category category3 = new Category();
        category3.setName("Mũ");
        iCategory.save(category3);
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
        iCategory.delete(1);
        Category category = iCategory.findById(1);
    }
}