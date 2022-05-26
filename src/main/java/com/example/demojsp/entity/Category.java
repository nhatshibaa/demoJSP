package com.example.demojsp.entity;

import com.example.demojsp.entity.base.BaseEntity;
import com.example.demojsp.entity.enums.CategoryStatus;

import java.time.LocalDateTime;

public class Category extends BaseEntity {
    private Integer id;
    private String name;
    private CategoryStatus status;

    public Category() {
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = CategoryStatus.ACTIVE;
    }

    public Category(String name, CategoryStatus status) {
        this.name = name;
        this.status = status;
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = CategoryStatus.ACTIVE;
    }

    public Category(Integer id, String name, CategoryStatus status) {
        this.id = id;
        this.name = name;
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.status = status;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
    }
}
